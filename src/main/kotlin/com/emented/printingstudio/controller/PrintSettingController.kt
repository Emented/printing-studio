package com.emented.printingstudio.controller

import com.emented.printingstudio.dto.PrintSettingResponseDto
import com.emented.printingstudio.service.PrintSettingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/print-setting")
class PrintSettingController(
    private val printSettingService: PrintSettingService,
) {

    @GetMapping
    fun printSettings(): ResponseEntity<List<PrintSettingResponseDto>> {
        return ResponseEntity.ok(printSettingService.printSettings())
    }
}
