package com.emented.printingstudio.model

import com.emented.printingstudio.model.enums.PaymentStatus
import com.emented.printingstudio.model.enums.PaymentType
import java.time.OffsetDateTime

data class Payment(
    val id: Long? = null,
    val type: PaymentType,
    val status: PaymentStatus,
    val creationTimestamp: OffsetDateTime? = null,
    val updateTimestamp: OffsetDateTime? = null,
)
