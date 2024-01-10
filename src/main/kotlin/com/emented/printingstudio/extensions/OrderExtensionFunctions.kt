package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.OrderResponseDto
import com.emented.printingstudio.model.Order

fun Order.toResponse(): OrderResponseDto {
    return OrderResponseDto(
        id = this.id!!,
        status = this.status,
        photoUrl = this.photoUrl,
        description = this.description,
        material = this.material.toResponse(),
        printSetting = this.printSetting.toResponse(),
        payment = this.payment.toResponse(),
        delivery = this.delivery.toResponse(),
        totalPrice = this.totalPrice,
        quantity = this.quantity,
        administrator = this.administrator?.toResponse(),
    )
}
