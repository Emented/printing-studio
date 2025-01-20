package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.PaymentResponseDto
import com.emented.printingstudio.dto.PaymentResponseDto.Status
import com.emented.printingstudio.dto.PaymentResponseDto.Type
import com.emented.printingstudio.model.Payment

fun Payment.toResponse(): PaymentResponseDto {
    return PaymentResponseDto(
        id = this.id!!,
        type = Type.valueOf(this.type.name),
        status = Status.valueOf(this.status.name),
    )
}
