package com.emented.printingstudio.service

import com.emented.printingstudio.dto.CheckoutRequestDto
import com.emented.printingstudio.dto.OrderResponseDto
import com.emented.printingstudio.model.enums.OrderStatus

interface OrderService {
    fun checkout(checkoutRequestDto: CheckoutRequestDto)
    fun customerOrders(customerId: Long): List<OrderResponseDto>
    fun administratorOrders(administratorId: Long): List<OrderResponseDto>
    fun orderById(orderId: Long): OrderResponseDto?
    fun updateOrderStatus(orderId: Long, targetStatus: OrderStatus)
}
