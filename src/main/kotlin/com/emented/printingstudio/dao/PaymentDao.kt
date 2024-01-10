package com.emented.printingstudio.dao

import com.emented.printingstudio.jooq.routines.references.setPaymentStatus
import com.emented.printingstudio.jooq.tables.references.PAYMENT
import com.emented.printingstudio.jooq.tables.references.PAYMENT_STATUS
import com.emented.printingstudio.jooq.tables.references.PAYMENT_TYPE
import com.emented.printingstudio.model.Payment
import com.emented.printingstudio.model.enums.PaymentStatus
import com.emented.printingstudio.model.enums.PaymentType
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.impl.DSL.select
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class PaymentDao(
    private val dslContext: DSLContext,
) {

    fun create(payment: Payment): Payment? {
        val now = OffsetDateTime.now()
        return dslContext.insertInto(PAYMENT)
            .set(
                PAYMENT.TYPE,
                select(PAYMENT_TYPE.ID).from(PAYMENT_TYPE).where(PAYMENT_TYPE.VALUE.eq(payment.type.name)),
            )
            .set(
                PAYMENT.STATUS,
                select(PAYMENT_STATUS.ID).from(PAYMENT_STATUS).where(PAYMENT_STATUS.VALUE.eq(payment.status.name)),
            )
            .set(PAYMENT.CREATION_TIMESTAMP, now)
            .set(PAYMENT.UPDATE_TIMESTAMP, now)
            .onConflictDoNothing()
            .returning(emptyDeliveryFields)
            .fetchOne {
                mapEmptyPayment(it, payment.type, payment.status)
            }
    }

    fun updatePaymentStatus(paymentId: Long, targetStatus: PaymentStatus) {
        setPaymentStatus(dslContext.configuration(), paymentId, targetStatus.name)
    }

    companion object {
        val paymentFields = setOf(
            PAYMENT.ID,
            PAYMENT_TYPE.VALUE,
            PAYMENT_STATUS.VALUE,
            PAYMENT.CREATION_TIMESTAMP,
            PAYMENT.UPDATE_TIMESTAMP,
        )

        val emptyDeliveryFields = setOf(
            PAYMENT.ID,
            PAYMENT.CREATION_TIMESTAMP,
            PAYMENT.UPDATE_TIMESTAMP,
        )

        fun mapPayment(record: Record): Payment {
            return Payment(
                id = record.get(PAYMENT.ID),
                type = PaymentType.valueOf(record.get(PAYMENT_TYPE.VALUE)!!),
                status = PaymentStatus.valueOf(record.get(PAYMENT_STATUS.VALUE)!!),
                creationTimestamp = record.get(PAYMENT.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(PAYMENT.UPDATE_TIMESTAMP)!!,
            )
        }

        fun mapEmptyPayment(
            record: Record,
            type: PaymentType,
            status: PaymentStatus,
        ): Payment {
            return Payment(
                id = record.get(PAYMENT.ID)!!,
                type = type,
                status = status,
                creationTimestamp = record.get(PAYMENT.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(PAYMENT.UPDATE_TIMESTAMP)!!,
            )
        }
    }
}
