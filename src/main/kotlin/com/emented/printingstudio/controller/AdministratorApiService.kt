package com.emented.printingstudio.controller

import com.emented.printingstudio.api.AdministratorApiDelegate
import com.emented.printingstudio.dto.AdministratorResponseDto
import com.emented.printingstudio.service.AdministratorService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AdministratorApiService(
    private val administratorService: AdministratorService,
) : AdministratorApiDelegate {

    override fun administratorByUserId(userId: Long): ResponseEntity<AdministratorResponseDto> {
        return administratorService.administratorByUserId(userId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}
