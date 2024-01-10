package com.emented.printingstudio.model

import java.math.BigDecimal
import java.time.OffsetDateTime

data class PrintSetting(
    val id: Long?,
    val description: String,
    val price: BigDecimal,
    val creationTimestamp: OffsetDateTime,
    val updateTimestamp: OffsetDateTime,
)
