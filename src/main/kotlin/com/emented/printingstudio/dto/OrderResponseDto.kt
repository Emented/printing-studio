package com.emented.printingstudio.dto

import com.emented.printingstudio.model.enums.OrderStatus
import java.math.BigDecimal

data class OrderResponseDto(
    val id: Long,
    val status: OrderStatus,
    val photoUrl: String?,
    val description: String,
    val material: MaterialResponseDto,
    val printSetting: PrintSettingResponseDto,
    val payment: PaymentResponseDto,
    val delivery: DeliveryResponseDto,
    val totalPrice: BigDecimal,
    val quantity: Int,
    val administrator: AdministratorResponseDto?,
)
