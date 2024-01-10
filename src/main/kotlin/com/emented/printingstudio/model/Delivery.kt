package com.emented.printingstudio.model

import com.emented.printingstudio.model.enums.DeliveryStatus
import com.emented.printingstudio.model.enums.DeliveryType
import java.time.OffsetDateTime

data class Delivery(
    val id: Long? = null,
    val type: DeliveryType,
    val status: DeliveryStatus,
    val creationTimestamp: OffsetDateTime? = null,
    val updateTimestamp: OffsetDateTime? = null,
)
