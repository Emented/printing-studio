package com.emented.printingstudio.dto

import com.emented.printingstudio.model.enums.AvailabilityStatus
import com.emented.printingstudio.model.enums.FilamentType
import java.math.BigDecimal

data class MaterialResponseDto(
    val id: Long,
    val type: FilamentType,
    val availabilityStatus: AvailabilityStatus,
    val stock: Long,
    val description: String,
    val price: BigDecimal,
    val color: String,
)
