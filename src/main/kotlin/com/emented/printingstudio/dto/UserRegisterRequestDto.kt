package com.emented.printingstudio.dto

data class UserRegisterRequestDto(
    val username: String,
    val password: String,
    val name: String,
    val surname: String,
    val patronymic: String?,
    val phone: String,
    val email: String,
    val address: String,
    val businessInfo: BusinessInfoRegisterRequestDto?,
)
