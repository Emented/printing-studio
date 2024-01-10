package com.emented.printingstudio.dto

import com.emented.printingstudio.model.enums.DeliveryType
import com.emented.printingstudio.model.enums.PaymentType

data class CheckoutRequestDto(
    val customerId: Long,
    val photoUrl: String?,
    val description: String,
    val material: String,
    val printSetting: String,
    val paymentType: PaymentType,
    val deliveryType: DeliveryType,
    val quantity: Int,
)
