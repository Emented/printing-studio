package com.emented.printingstudio.controller

import com.emented.printingstudio.dto.MaterialResponseDto
import com.emented.printingstudio.service.MaterialService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/material")
class MaterialController(
    private val materialService: MaterialService,
) {

    @GetMapping
    fun materials(): ResponseEntity<List<MaterialResponseDto>> {
        return ResponseEntity.ok(materialService.materials())
    }
}
