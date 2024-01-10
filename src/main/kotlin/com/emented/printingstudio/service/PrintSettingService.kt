package com.emented.printingstudio.service

import com.emented.printingstudio.dto.PrintSettingResponseDto

interface PrintSettingService {

    fun printSettings(): List<PrintSettingResponseDto>
}
