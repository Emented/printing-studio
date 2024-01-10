package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.PaymentResponseDto
import com.emented.printingstudio.model.Payment

fun Payment.toResponse(): PaymentResponseDto {
    return PaymentResponseDto(
        id = this.id!!,
        type = this.type,
        status = this.status,
    )
}
