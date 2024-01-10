package com.emented.printingstudio.dto

data class BusinessInfoResponseDto(
    val id: Long,
    val inn: String,
    val kpp: String?,
    val companyName: String,
)
