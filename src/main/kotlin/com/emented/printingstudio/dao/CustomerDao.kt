package com.emented.printingstudio.dao

import com.emented.printingstudio.jooq.tables.references.BUSINESS_INFO
import com.emented.printingstudio.jooq.tables.references.CUSTOMER
import com.emented.printingstudio.jooq.tables.references.USER
import com.emented.printingstudio.model.BusinessInfo
import com.emented.printingstudio.model.Customer
import com.emented.printingstudio.model.User
import org.jooq.DSLContext
import org.jooq.Record
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class CustomerDao(
    private val dslContext: DSLContext,
) {
    fun create(customer: Customer): Customer? {
        val now = OffsetDateTime.now()

        val persistedInfo = customer.businessInfo?.let {
            dslContext.insertInto(BUSINESS_INFO)
                .set(BUSINESS_INFO.INN, it.inn)
                .set(BUSINESS_INFO.KPP, it.kpp)
                .set(BUSINESS_INFO.COMPANY_NAME, it.companyName)
                .set(BUSINESS_INFO.CREATION_TIMESTAMP, now)
                .set(BUSINESS_INFO.UPDATE_TIMESTAMP, now)
                .onConflictDoNothing()
                .returning(businessInfoFields)
                .fetchOne(CustomerDao::mapBusinessInfo)
        }

        return dslContext.insertInto(CUSTOMER)
            .set(CUSTOMER.USER_ID, customer.user.id)
            .set(CUSTOMER.BUSINESS_INFO_ID, persistedInfo?.id)
            .set(CUSTOMER.CREATION_TIMESTAMP, now)
            .set(CUSTOMER.UPDATE_TIMESTAMP, now)
            .onConflictDoNothing()
            .returning(customerFields)
            .fetchOne {
                mapEmptyCustomer(it, customer.user, persistedInfo)
            }
    }

    fun getCustomerByUserId(userId: Long): Customer? {
        return dslContext.select(
            customerFields + businessInfoFields + UserDao.userFields,
        ).from(CUSTOMER)
            .join(USER).on(CUSTOMER.USER_ID.eq(USER.ID))
            .leftJoin(BUSINESS_INFO).on(CUSTOMER.BUSINESS_INFO_ID.eq(BUSINESS_INFO.ID))
            .where(CUSTOMER.USER_ID.eq(userId))
            .fetchOne(CustomerDao::mapCustomer)
    }

    companion object {
        val customerFields = setOf(
            CUSTOMER.ID,
            CUSTOMER.CREATION_TIMESTAMP,
            CUSTOMER.UPDATE_TIMESTAMP,
        )

        val businessInfoFields = setOf(
            BUSINESS_INFO.ID,
            BUSINESS_INFO.INN,
            BUSINESS_INFO.KPP,
            BUSINESS_INFO.COMPANY_NAME,
            BUSINESS_INFO.CREATION_TIMESTAMP,
            BUSINESS_INFO.UPDATE_TIMESTAMP,
        )

        fun mapEmptyCustomer(
            record: Record,
            user: User,
            businessInfo: BusinessInfo?,
        ): Customer {
            return Customer(
                id = record.get(CUSTOMER.ID)!!,
                user = user,
                businessInfo = businessInfo,
                socialNetworks = listOf(),
                creationTimestamp = record.get(CUSTOMER.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(CUSTOMER.UPDATE_TIMESTAMP)!!,
            )
        }

        fun mapCustomer(record: Record): Customer {
            return Customer(
                id = record.get(CUSTOMER.ID)!!,
                user = UserDao.mapUser(record),
                businessInfo = mapBusinessInfo(record),
                socialNetworks = listOf(),
                creationTimestamp = record.get(CUSTOMER.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(CUSTOMER.UPDATE_TIMESTAMP)!!,
            )
        }

        fun mapBusinessInfo(record: Record): BusinessInfo? {
            if (record.get(BUSINESS_INFO.ID) == null) {
                return null
            }

            return BusinessInfo(
                id = record.get(BUSINESS_INFO.ID)!!,
                inn = record.get(BUSINESS_INFO.INN)!!,
                kpp = record.get(BUSINESS_INFO.KPP),
                companyName = record.get(BUSINESS_INFO.COMPANY_NAME)!!,
                creationTimestamp = record.get(BUSINESS_INFO.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(BUSINESS_INFO.UPDATE_TIMESTAMP)!!,
            )
        }
    }
}
