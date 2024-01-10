package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.AccountType
import com.emented.printingstudio.dto.UserResponseDto
import com.emented.printingstudio.model.User

fun User.toResponse(customerId: Long?, administratorId: Long?): UserResponseDto {
    return UserResponseDto(
        id = this.id!!,
        customerId = customerId,
        administratorId = administratorId,
        username = this.username,
        password = this.passwordHash,
        name = this.name,
        surname = this.surname,
        patronymic = this.patronymic,
        phone = this.phone,
        email = this.email,
        accountType = customerId?.let { AccountType.CUSTOMER } ?: AccountType.ADMINISTRATOR,
    )
}
