package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.MaterialResponseDto
import com.emented.printingstudio.model.Material

fun Material.toResponse(): MaterialResponseDto {
    return MaterialResponseDto(
        id = this.id,
        type = this.type,
        availabilityStatus = this.availabilityStatus,
        stock = this.stock,
        description = this.description,
        price = this.price,
        color = this.color,
    )
}
