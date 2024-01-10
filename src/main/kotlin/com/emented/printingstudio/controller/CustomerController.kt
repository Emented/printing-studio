package com.emented.printingstudio.controller

import com.emented.printingstudio.dto.CustomerResponseDto
import com.emented.printingstudio.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController(
    private val customerService: CustomerService,
) {

    @GetMapping("/{userId}")
    fun customerByUserId(@PathVariable userId: Long): ResponseEntity<CustomerResponseDto> {
        return customerService.customerByUserId(userId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}
