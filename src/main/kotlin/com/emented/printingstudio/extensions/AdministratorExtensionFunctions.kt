package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.AdministratorResponseDto
import com.emented.printingstudio.model.Administrator

fun Administrator.toResponse(): AdministratorResponseDto {
    return AdministratorResponseDto(
        id = this.id!!,
        user = this.user.toResponse(null, this.id),
    )
}
