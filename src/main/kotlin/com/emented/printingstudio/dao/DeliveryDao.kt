package com.emented.printingstudio.dao

import com.emented.printingstudio.jooq.routines.references.setDeliveryStatus
import com.emented.printingstudio.jooq.tables.references.DELIVERY
import com.emented.printingstudio.jooq.tables.references.DELIVERY_STATUS
import com.emented.printingstudio.jooq.tables.references.DELIVERY_TYPE
import com.emented.printingstudio.model.Delivery
import com.emented.printingstudio.model.enums.DeliveryStatus
import com.emented.printingstudio.model.enums.DeliveryType
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.impl.DSL.select
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class DeliveryDao(
    private val dslContext: DSLContext,
) {

    fun create(delivery: Delivery): Delivery? {
        val now = OffsetDateTime.now()
        return dslContext.insertInto(DELIVERY)
            .set(
                DELIVERY.TYPE,
                select(DELIVERY_TYPE.ID).from(DELIVERY_TYPE).where(DELIVERY_TYPE.VALUE.eq(delivery.type.name)),
            )
            .set(
                DELIVERY.STATUS,
                select(DELIVERY_STATUS.ID).from(DELIVERY_STATUS).where(DELIVERY_STATUS.VALUE.eq(delivery.status.name)),
            )
            .set(DELIVERY.CREATION_TIMESTAMP, now)
            .set(DELIVERY.UPDATE_TIMESTAMP, now)
            .onConflictDoNothing()
            .returning(emptyDeliveryFields)
            .fetchOne {
                mapEmptyDelivery(it, delivery.type, delivery.status)
            }
    }

    fun updateDeliveryStatus(deliveryId: Long, targetStatus: DeliveryStatus) {
        setDeliveryStatus(dslContext.configuration(), deliveryId, targetStatus.name)
    }

    companion object {
        val deliveryFields = setOf(
            DELIVERY.ID,
            DELIVERY_TYPE.VALUE,
            DELIVERY_STATUS.VALUE,
            DELIVERY.CREATION_TIMESTAMP,
            DELIVERY.UPDATE_TIMESTAMP,
        )

        val emptyDeliveryFields = setOf(
            DELIVERY.ID,
            DELIVERY.CREATION_TIMESTAMP,
            DELIVERY.UPDATE_TIMESTAMP,
        )

        fun mapDelivery(record: Record): Delivery {
            return Delivery(
                id = record.get(DELIVERY.ID)!!,
                type = DeliveryType.valueOf(record.get(DELIVERY_TYPE.VALUE)!!),
                status = DeliveryStatus.valueOf(record.get(DELIVERY_STATUS.VALUE)!!),
                creationTimestamp = record.get(DELIVERY.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(DELIVERY.UPDATE_TIMESTAMP)!!,
            )
        }

        fun mapEmptyDelivery(
            record: Record,
            type: DeliveryType,
            status: DeliveryStatus,
        ): Delivery {
            return Delivery(
                id = record.get(DELIVERY.ID)!!,
                type = type,
                status = status,
                creationTimestamp = record.get(DELIVERY.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(DELIVERY.UPDATE_TIMESTAMP)!!,
            )
        }
    }
}
