package com.emented.printingstudio.controller

import com.emented.printingstudio.dto.CheckoutRequestDto
import com.emented.printingstudio.dto.OrderResponseDto
import com.emented.printingstudio.dto.ResponseStatusCode
import com.emented.printingstudio.dto.StatusResponseDto
import com.emented.printingstudio.model.enums.OrderStatus
import com.emented.printingstudio.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService,
) {
    @GetMapping("/customer/{customerId}")
    fun customerOrders(@PathVariable customerId: Long): ResponseEntity<List<OrderResponseDto>> {
        return ResponseEntity.ok(orderService.customerOrders(customerId))
    }

    @GetMapping("/administrator/{administratorId}")
    fun administratorOrders(@PathVariable administratorId: Long): ResponseEntity<List<OrderResponseDto>> {
        return ResponseEntity.ok(orderService.administratorOrders(administratorId))
    }

    @GetMapping("/{orderId}")
    fun orderById(@PathVariable orderId: Long): ResponseEntity<OrderResponseDto> {
        return orderService.orderById(orderId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @PostMapping("/{orderId}/status")
    fun updateOrderStatus(
        @PathVariable orderId: Long,
        @RequestParam(required = true) targetStatus: OrderStatus,
    ) {
        orderService.updateOrderStatus(orderId, targetStatus)
    }

    @PostMapping("/{orderId}/cancel")
    fun cancelOrder(
        @PathVariable orderId: Long,
    ) {
        updateOrderStatus(orderId, OrderStatus.CANCELLED)
    }

    @PostMapping("/checkout")
    fun checkout(@RequestBody checkoutRequestDto: CheckoutRequestDto): ResponseEntity<StatusResponseDto> {
        return try {
            orderService.checkout(checkoutRequestDto)
            ResponseEntity.ok(
                StatusResponseDto(
                    status = ResponseStatusCode.SUCCESS,
                ),
            )
        } catch (exception: IllegalStateException) {
            ResponseEntity(
                StatusResponseDto(
                    status = ResponseStatusCode.ERROR,
                    message = exception.message,
                ),
                HttpStatus.BAD_REQUEST,
            )
        } catch (exception: Exception) {
            ResponseEntity(
                StatusResponseDto(
                    status = ResponseStatusCode.ERROR,
                    message = "Checkout failed!",
                ),
                HttpStatus.BAD_REQUEST,
            )
        }
    }
}
