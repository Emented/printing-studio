package com.emented.printingstudio.model

import java.time.OffsetDateTime

data class BusinessInfo(
    val id: Long? = null,
    val inn: String,
    val kpp: String?,
    val companyName: String,
    val creationTimestamp: OffsetDateTime? = null,
    val updateTimestamp: OffsetDateTime? = null,
)
