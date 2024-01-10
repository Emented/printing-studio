package com.emented.printingstudio.dto

import com.emented.printingstudio.model.enums.PaymentStatus
import com.emented.printingstudio.model.enums.PaymentType

data class PaymentResponseDto(
    val id: Long,
    val type: PaymentType,
    val status: PaymentStatus,
)
