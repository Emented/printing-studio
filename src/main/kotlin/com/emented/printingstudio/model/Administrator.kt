package com.emented.printingstudio.model

import java.time.OffsetDateTime

data class Administrator(
    val id: Long?,
    val user: User,
    val creationTimestamp: OffsetDateTime,
    val updateTimestamp: OffsetDateTime,
)
