package com.emented.printingstudio.dao

import com.emented.printingstudio.jooq.tables.references.ADMINISTRATOR
import com.emented.printingstudio.jooq.tables.references.USER
import com.emented.printingstudio.model.Administrator
import org.jooq.DSLContext
import org.jooq.Record
import org.springframework.stereotype.Repository

@Repository
class AdministratorDao(
    private val dslContext: DSLContext,
) {

    fun getAdministratorByUserId(userId: Long): Administrator? {
        return dslContext.select(
            administratorFields + UserDao.userFields,
        ).from(ADMINISTRATOR)
            .join(USER).on(ADMINISTRATOR.USER_ID.eq(USER.ID))
            .where(ADMINISTRATOR.USER_ID.eq(userId))
            .fetchOne(AdministratorDao::mapAdministrator)
    }

    companion object {
        val administratorFields = setOf(
            ADMINISTRATOR.ID,
            ADMINISTRATOR.CREATION_TIMESTAMP,
            ADMINISTRATOR.UPDATE_TIMESTAMP,
        )

        fun mapAdministrator(record: Record): Administrator {
            return Administrator(
                id = record.get(ADMINISTRATOR.ID)!!,
                user = UserDao.mapUser(record),
                creationTimestamp = record.get(ADMINISTRATOR.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(ADMINISTRATOR.UPDATE_TIMESTAMP)!!,
            )
        }
    }
}
