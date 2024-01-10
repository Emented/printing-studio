package com.emented.printingstudio.dao

import com.emented.printingstudio.jooq.routines.references.setOrderStatus
import com.emented.printingstudio.jooq.tables.references.ADMINISTRATOR
import com.emented.printingstudio.jooq.tables.references.AVAILABILITY_STATUS
import com.emented.printingstudio.jooq.tables.references.DELIVERY
import com.emented.printingstudio.jooq.tables.references.DELIVERY_STATUS
import com.emented.printingstudio.jooq.tables.references.DELIVERY_TYPE
import com.emented.printingstudio.jooq.tables.references.FILAMENT_TYPE
import com.emented.printingstudio.jooq.tables.references.MATERIAL
import com.emented.printingstudio.jooq.tables.references.ORDER
import com.emented.printingstudio.jooq.tables.references.ORDER_STATUS
import com.emented.printingstudio.jooq.tables.references.PAYMENT
import com.emented.printingstudio.jooq.tables.references.PAYMENT_STATUS
import com.emented.printingstudio.jooq.tables.references.PAYMENT_TYPE
import com.emented.printingstudio.jooq.tables.references.PRINT_SETTING
import com.emented.printingstudio.jooq.tables.references.USER
import com.emented.printingstudio.model.Administrator
import com.emented.printingstudio.model.Delivery
import com.emented.printingstudio.model.Material
import com.emented.printingstudio.model.Order
import com.emented.printingstudio.model.Payment
import com.emented.printingstudio.model.PrintSetting
import com.emented.printingstudio.model.enums.OrderStatus
import org.jooq.Condition
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.impl.DSL.select
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class OrderDao(
    private val dslContext: DSLContext,
) {

    fun create(customerId: Long, order: Order): Order? {
        val now = OffsetDateTime.now()
        return dslContext.insertInto(ORDER)
            .set(ORDER.CUSTOMER_ID, customerId)
            .set(
                DELIVERY.STATUS,
                select(ORDER_STATUS.ID).from(ORDER_STATUS).where(ORDER_STATUS.VALUE.eq(order.status.name)),
            )
            .set(ORDER.PHOTO_URL, order.photoUrl)
            .set(ORDER.DESCRIPTION, order.description)
            .set(ORDER.MATERIAL_ID, order.material.id)
            .set(ORDER.PRINT_SETTING_ID, order.printSetting.id)
            .set(ORDER.PAYMENT_ID, order.payment.id)
            .set(ORDER.DELIVERY_ID, order.delivery.id)
            .set(ORDER.TOTAL_PRICE, order.totalPrice)
            .set(ORDER.QUANTITY, order.quantity)
            .set(ORDER.ADMINISTRATOR_ID, order.administrator?.id)
            .set(ORDER.CREATION_TIMESTAMP, now)
            .set(ORDER.UPDATE_TIMESTAMP, now)
            .onConflictDoNothing()
            .returning(emptyOrderFields)
            .fetchOne {
                mapEmptyOrder(
                    it,
                    order.status,
                    order.material,
                    order.printSetting,
                    order.payment,
                    order.delivery,
                    order.administrator,
                )
            }
    }

    fun getOrderById(orderId: Long): Order? {
        return selectOrders(ORDER.ID.eq(orderId)).firstOrNull()
    }

    fun getCustomerOrders(customerId: Long): List<Order> {
        return selectOrders(ORDER.CUSTOMER_ID.eq(customerId))
    }

    fun getAdministratorOrders(administratorId: Long): List<Order> {
        return selectOrders(ORDER.ADMINISTRATOR_ID.eq(administratorId))
    }

    fun updateOrderStatus(orderId: Long, targetStatus: OrderStatus) {
        setOrderStatus(dslContext.configuration(), orderId, targetStatus.name)
    }

    private fun selectOrders(condition: Condition): List<Order> {
        return dslContext.select(
            orderFields +
                DeliveryDao.deliveryFields +
                PaymentDao.paymentFields +
                MaterialDao.materialFields +
                PrintSettingDao.printSettingFields +
                AdministratorDao.administratorFields +
                UserDao.userFields,
        )
            .from(ORDER)
            .join(ORDER_STATUS).on(ORDER.STATUS.eq(ORDER_STATUS.ID))
            .join(MATERIAL).on(ORDER.MATERIAL_ID.eq(MATERIAL.ID))
            .join(FILAMENT_TYPE).on(MATERIAL.TYPE.eq(FILAMENT_TYPE.ID))
            .join(AVAILABILITY_STATUS).on(MATERIAL.AVAILABILITY_STATUS.eq(AVAILABILITY_STATUS.ID))
            .join(PRINT_SETTING).on(ORDER.PRINT_SETTING_ID.eq(PRINT_SETTING.ID))
            .join(PAYMENT).on(ORDER.PAYMENT_ID.eq(PAYMENT.ID))
            .join(PAYMENT_TYPE).on(PAYMENT.TYPE.eq(PAYMENT_TYPE.ID))
            .join(PAYMENT_STATUS).on(PAYMENT.STATUS.eq(PAYMENT_STATUS.ID))
            .leftJoin(DELIVERY).on(ORDER.DELIVERY_ID.eq(DELIVERY.ID))
            .join(DELIVERY_TYPE).on(DELIVERY.TYPE.eq(DELIVERY_TYPE.ID))
            .join(DELIVERY_STATUS).on(DELIVERY.STATUS.eq(DELIVERY_STATUS.ID))
            .leftJoin(ADMINISTRATOR).on(ORDER.ADMINISTRATOR_ID.eq(ADMINISTRATOR.ID))
            .leftJoin(USER).on(ADMINISTRATOR.USER_ID.eq(USER.ID))
            .where(condition)
            .fetch(OrderDao::mapOrder)
    }

    companion object {
        val orderFields = setOf(
            ORDER.ID,
            ORDER_STATUS.VALUE,
            ORDER.PHOTO_URL,
            ORDER.DESCRIPTION,
            ORDER.TOTAL_PRICE,
            ORDER.QUANTITY,
            ORDER.CREATION_TIMESTAMP,
            ORDER.UPDATE_TIMESTAMP,
        )

        val emptyOrderFields = setOf(
            ORDER.ID,
            ORDER.PHOTO_URL,
            ORDER.DESCRIPTION,
            ORDER.TOTAL_PRICE,
            ORDER.QUANTITY,
            ORDER.CREATION_TIMESTAMP,
            ORDER.UPDATE_TIMESTAMP,
        )

        fun mapOrder(record: Record): Order {
            return Order(
                id = record.get(ORDER.ID)!!,
                status = OrderStatus.valueOf(record.get(ORDER_STATUS.VALUE)!!),
                photoUrl = record.get(ORDER.PHOTO_URL)!!,
                description = record.get(ORDER.DESCRIPTION)!!,
                material = MaterialDao.mapMaterial(record),
                printSetting = PrintSettingDao.mapPrintSetting(record),
                payment = PaymentDao.mapPayment(record),
                delivery = DeliveryDao.mapDelivery(record),
                totalPrice = record.get(ORDER.TOTAL_PRICE)!!,
                quantity = record.get(ORDER.QUANTITY)!!,
                administrator = record.get(ADMINISTRATOR.ID)?.let { AdministratorDao.mapAdministrator(record) },
                creationTimestamp = record.get(ORDER.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(ORDER.UPDATE_TIMESTAMP)!!,
            )
        }

        fun mapEmptyOrder(
            record: Record,
            orderStatus: OrderStatus,
            material: Material,
            printSetting: PrintSetting,
            payment: Payment,
            delivery: Delivery,
            administrator: Administrator?,
        ): Order {
            return Order(
                id = record.get(ORDER.ID)!!,
                status = orderStatus,
                photoUrl = record.get(ORDER.PHOTO_URL)!!,
                description = record.get(ORDER.DESCRIPTION)!!,
                material = material,
                printSetting = printSetting,
                payment = payment,
                delivery = delivery,
                totalPrice = record.get(ORDER.TOTAL_PRICE)!!,
                quantity = record.get(ORDER.QUANTITY)!!,
                administrator = administrator,
                creationTimestamp = record.get(ORDER.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(ORDER.UPDATE_TIMESTAMP)!!,
            )
        }
    }
}
