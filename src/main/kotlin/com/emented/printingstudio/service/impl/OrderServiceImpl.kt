package com.emented.printingstudio.service.impl

import com.emented.printingstudio.dao.DeliveryDao
import com.emented.printingstudio.dao.MaterialDao
import com.emented.printingstudio.dao.OrderDao
import com.emented.printingstudio.dao.PaymentDao
import com.emented.printingstudio.dao.PrintSettingDao
import com.emented.printingstudio.dto.CheckoutRequestDto
import com.emented.printingstudio.dto.OrderResponseDto
import com.emented.printingstudio.extensions.toResponse
import com.emented.printingstudio.model.Delivery
import com.emented.printingstudio.model.Material
import com.emented.printingstudio.model.Order
import com.emented.printingstudio.model.Payment
import com.emented.printingstudio.model.PrintSetting
import com.emented.printingstudio.model.enums.DeliveryStatus
import com.emented.printingstudio.model.enums.DeliveryType
import com.emented.printingstudio.model.enums.OrderStatus
import com.emented.printingstudio.model.enums.PaymentStatus
import com.emented.printingstudio.model.enums.PaymentType
import com.emented.printingstudio.service.OrderService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class OrderServiceImpl(
    private val orderDao: OrderDao,
    private val deliveryDao: DeliveryDao,
    private val paymentDao: PaymentDao,
    private val materialDao: MaterialDao,
    private val printSettingDao: PrintSettingDao,
) : OrderService {
    override fun customerOrders(customerId: Long): List<OrderResponseDto> {
        val orders = orderDao.getCustomerOrders(customerId)

        return orders.map(Order::toResponse)
    }

    override fun administratorOrders(administratorId: Long): List<OrderResponseDto> {
        val orders = orderDao.getAdministratorOrders(administratorId)

        return orders.map(Order::toResponse)
    }

    override fun orderById(orderId: Long): OrderResponseDto? {
        return orderDao.getOrderById(orderId)?.toResponse()
    }

    @Transactional
    override fun updateOrderStatus(orderId: Long, targetStatus: OrderStatus) {
        orderDao.updateOrderStatus(orderId, targetStatus)
    }

    @Transactional
    override fun checkout(checkoutRequestDto: CheckoutRequestDto) {
        val material = materialDao.getMaterialByFilamentType(checkoutRequestDto.material)
            ?: throw IllegalStateException("Material not found!")
        val printSetting = printSettingDao.getPrintSettingByDescription(checkoutRequestDto.printSetting)
            ?: throw IllegalStateException("Print setting not found!")

        val delivery = createDefaultDelivery(checkoutRequestDto.deliveryType)
        val payment = createDefaultPayment(checkoutRequestDto.paymentType)

        val persistedDelivery = deliveryDao.create(delivery)
            ?: throw IllegalStateException("Unable to create delivery!")
        val persistedPayment = paymentDao.create(payment) ?: throw IllegalStateException("Unable to create payment!")

        val order = checkoutRequestDto.toOrderModel(material, printSetting, persistedDelivery, persistedPayment)
        orderDao.create(checkoutRequestDto.customerId, order) ?: throw IllegalStateException("Unable to create order!")
    }

    private fun createDefaultDelivery(type: DeliveryType): Delivery {
        return Delivery(
            type = type,
            status = DeliveryStatus.CREATED,
        )
    }

    private fun createDefaultPayment(type: PaymentType): Payment {
        return Payment(
            type = type,
            status = PaymentStatus.CREATED,
        )
    }
}

private fun CheckoutRequestDto.toOrderModel(
    material: Material,
    printSetting: PrintSetting,
    delivery: Delivery,
    payment: Payment,
): Order {
    return Order(
        status = OrderStatus.CREATED,
        photoUrl = this.photoUrl,
        description = this.description,
        material = material,
        printSetting = printSetting,
        payment = payment,
        delivery = delivery,
        totalPrice = material.price.multiply(BigDecimal(this.quantity)),
        quantity = this.quantity,
        administrator = null,
    )
}
