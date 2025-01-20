package com.emented.printingstudio.controller

import com.emented.printingstudio.api.PrintSettingApiDelegate
import com.emented.printingstudio.dto.PrintSettingResponseDto
import com.emented.printingstudio.service.PrintSettingService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PrintSettingApiService(
    private val printSettingService: PrintSettingService,
) : PrintSettingApiDelegate {

    override fun printSettings(): ResponseEntity<List<PrintSettingResponseDto>> {
        return ResponseEntity.ok(printSettingService.printSettings())
    }
}
