package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.PrintSettingResponseDto
import com.emented.printingstudio.model.PrintSetting

fun PrintSetting.toResponse(): PrintSettingResponseDto {
    return PrintSettingResponseDto(
        id = this.id,
        description = this.description,
        price = this.price,
    )
}
