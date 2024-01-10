package com.emented.printingstudio.model

import java.time.OffsetDateTime

data class User(
    val id: Long? = null,
    val username: String,
    val passwordHash: String,
    val name: String,
    val surname: String,
    val patronymic: String?,
    val phone: String,
    val email: String,
    val address: String,
    val creationTimestamp: OffsetDateTime? = null,
    val updateTimestamp: OffsetDateTime? = null,
)
