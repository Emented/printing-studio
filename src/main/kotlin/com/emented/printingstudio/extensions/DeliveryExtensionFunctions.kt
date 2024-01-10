package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.DeliveryResponseDto
import com.emented.printingstudio.model.Delivery

fun Delivery.toResponse(): DeliveryResponseDto {
    return DeliveryResponseDto(
        id = this.id!!,
        type = this.type,
        status = this.status,
    )
}
