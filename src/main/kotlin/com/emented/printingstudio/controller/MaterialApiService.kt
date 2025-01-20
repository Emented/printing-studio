package com.emented.printingstudio.controller

import com.emented.printingstudio.api.MaterialApiDelegate
import com.emented.printingstudio.dto.MaterialResponseDto
import com.emented.printingstudio.service.MaterialService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MaterialApiService(
    private val materialService: MaterialService,
) : MaterialApiDelegate {

    override fun materials(): ResponseEntity<List<MaterialResponseDto>> {
        return ResponseEntity.ok(materialService.materials())
    }
}
