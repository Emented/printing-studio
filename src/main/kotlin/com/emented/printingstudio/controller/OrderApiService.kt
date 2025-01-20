package com.emented.printingstudio.controller

import com.emented.printingstudio.api.OrderApiDelegate
import com.emented.printingstudio.dto.CheckoutRequestDto
import com.emented.printingstudio.dto.OrderResponseDto
import com.emented.printingstudio.dto.StatusResponseDto
import com.emented.printingstudio.dto.StatusResponseDto.Status
import com.emented.printingstudio.model.enums.OrderStatus
import com.emented.printingstudio.service.OrderService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class OrderApiService(
    private val orderService: OrderService,
) : OrderApiDelegate {

    override fun customerOrders(customerId: Long): ResponseEntity<List<OrderResponseDto>> {
        return ResponseEntity.ok(orderService.customerOrders(customerId))
    }

    override fun administratorOrders(administratorId: Long): ResponseEntity<List<OrderResponseDto>> {
        return ResponseEntity.ok(orderService.administratorOrders(administratorId))
    }

    override fun orderById(orderId: Long): ResponseEntity<OrderResponseDto> {
        return orderService.orderById(orderId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    override fun updateOrderStatus(
        orderId: Long,
        targetStatus: String,
    ): ResponseEntity<Unit> {
        orderService.updateOrderStatus(orderId, OrderStatus.valueOf(targetStatus))
        return ResponseEntity.ok().build()
    }

    override fun cancelOrder(orderId: Long): ResponseEntity<Unit> {
        return updateOrderStatus(orderId, OrderStatus.CANCELLED.name)
    }

    override fun checkout(checkoutRequestDto: CheckoutRequestDto): ResponseEntity<StatusResponseDto> {
        return try {
            orderService.checkout(checkoutRequestDto)
            ResponseEntity.ok(
                StatusResponseDto(
                    status = Status.SUCCESS,
                ),
            )
        } catch (exception: IllegalStateException) {
            ResponseEntity(
                StatusResponseDto(
                    status = Status.ERROR,
                    message = exception.message,
                ),
                HttpStatus.BAD_REQUEST,
            )
        } catch (e: Exception) {
            log.error("Error during checkout", e)
            ResponseEntity(
                StatusResponseDto(
                    status = Status.ERROR,
                    message = "Checkout failed!",
                ),
                HttpStatus.BAD_REQUEST,
            )
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(OrderApiService::class.java)
    }
}
