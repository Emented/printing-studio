package com.emented.printingstudio.controller

import com.emented.printingstudio.api.CustomerApiDelegate
import com.emented.printingstudio.dto.CustomerResponseDto
import com.emented.printingstudio.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CustomerApiService(
    private val customerService: CustomerService,
) : CustomerApiDelegate {

    override fun customerByUserId(userId: Long): ResponseEntity<CustomerResponseDto> {
        return customerService.customerByUserId(userId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}
