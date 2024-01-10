package com.emented.printingstudio.dto

import com.emented.printingstudio.model.enums.DeliveryStatus
import com.emented.printingstudio.model.enums.DeliveryType

data class DeliveryResponseDto(
    val id: Long,
    val type: DeliveryType,
    val status: DeliveryStatus,
)
