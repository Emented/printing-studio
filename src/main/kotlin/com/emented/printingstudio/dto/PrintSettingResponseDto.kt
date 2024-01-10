package com.emented.printingstudio.dto

import java.math.BigDecimal

data class PrintSettingResponseDto(
    val id: Long?,
    val description: String,
    val price: BigDecimal,
)
