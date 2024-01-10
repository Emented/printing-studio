package com.emented.printingstudio.service

import com.emented.printingstudio.dto.CustomerResponseDto

interface CustomerService {
    fun customerByUserId(userId: Long): CustomerResponseDto?
}
