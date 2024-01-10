package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.BusinessInfoResponseDto
import com.emented.printingstudio.model.BusinessInfo

fun BusinessInfo.toResponse(): BusinessInfoResponseDto {
    return BusinessInfoResponseDto(
        id = this.id!!,
        inn = this.inn,
        kpp = this.kpp,
        companyName = this.companyName,
    )
}
