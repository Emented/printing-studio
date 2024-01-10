package com.emented.printingstudio.controller

import com.emented.printingstudio.dto.AdministratorResponseDto
import com.emented.printingstudio.service.AdministratorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/administrator")
class AdministratorController(
    private val administratorService: AdministratorService,
) {

    @GetMapping("/{userId}")
    fun administratorByUserId(@PathVariable userId: Long): ResponseEntity<AdministratorResponseDto> {
        return administratorService.administratorByUserId(userId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}
