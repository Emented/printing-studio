package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.CustomerResponseDto
import com.emented.printingstudio.model.Customer

fun Customer.toResponse(): CustomerResponseDto {
    return CustomerResponseDto(
        id = this.id!!,
        user = this.user.toResponse(this.id, null),
        businessInfo = this.businessInfo?.toResponse(),
        socialNetworks = listOf(),
    )
}
