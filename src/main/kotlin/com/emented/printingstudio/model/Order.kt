package com.emented.printingstudio.model

import com.emented.printingstudio.model.enums.OrderStatus
import java.math.BigDecimal
import java.time.OffsetDateTime

data class Order(
    val id: Long? = null,
    val status: OrderStatus,
    val photoUrl: String?,
    val description: String,
    val material: Material,
    val printSetting: PrintSetting,
    val payment: Payment,
    val delivery: Delivery,
    val totalPrice: BigDecimal,
    val quantity: Int,
    val administrator: Administrator?,
    val creationTimestamp: OffsetDateTime? = null,
    val updateTimestamp: OffsetDateTime? = null,
)
