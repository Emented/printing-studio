package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.DeliveryResponseDto
import com.emented.printingstudio.dto.DeliveryResponseDto.Status
import com.emented.printingstudio.dto.DeliveryResponseDto.Type
import com.emented.printingstudio.model.Delivery

fun Delivery.toResponse(): DeliveryResponseDto {
    return DeliveryResponseDto(
        id = this.id!!,
        type = Type.valueOf(this.type.name),
        status = Status.valueOf(this.status.name),
    )
}
