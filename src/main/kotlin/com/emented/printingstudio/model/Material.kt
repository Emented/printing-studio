package com.emented.printingstudio.model

import com.emented.printingstudio.model.enums.AvailabilityStatus
import com.emented.printingstudio.model.enums.FilamentType
import java.math.BigDecimal
import java.time.OffsetDateTime

data class Material(
    val id: Long,
    val type: FilamentType,
    val availabilityStatus: AvailabilityStatus,
    val stock: Long,
    val description: String,
    val price: BigDecimal,
    val color: String,
    val creationTimestamp: OffsetDateTime,
    val updateTimestamp: OffsetDateTime,
)
