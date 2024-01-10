package com.emented.printingstudio.model

import java.time.OffsetDateTime

data class Customer(
    val id: Long? = null,
    val user: User,
    val businessInfo: BusinessInfo?,
    val socialNetworks: List<SocialNetwork>,
    val creationTimestamp: OffsetDateTime? = null,
    val updateTimestamp: OffsetDateTime? = null,
)
