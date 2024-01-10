package com.emented.printingstudio.dto

data class UserResponseDto(
    val id: Long,
    val customerId: Long?,
    val administratorId: Long?,
    val username: String,
    val password: String,
    val name: String,
    val surname: String,
    val patronymic: String?,
    val phone: String,
    val email: String,
    val accountType: AccountType,
)
