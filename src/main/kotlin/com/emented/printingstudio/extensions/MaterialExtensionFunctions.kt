package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.MaterialResponseDto
import com.emented.printingstudio.dto.MaterialResponseDto.AvailabilityStatus
import com.emented.printingstudio.dto.MaterialResponseDto.Type
import com.emented.printingstudio.model.Material

fun Material.toResponse(): MaterialResponseDto {
    return MaterialResponseDto(
        id = this.id,
        type = Type.valueOf(this.type.name),
        availabilityStatus = AvailabilityStatus.valueOf(this.availabilityStatus.name),
        stock = this.stock,
        description = this.description,
        price = this.price,
        color = this.color,
    )
}
