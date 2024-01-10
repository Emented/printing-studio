package com.emented.printingstudio.dto

data class StatusResponseDto(
    val status: ResponseStatusCode,
    val message: String? = null,
)
