package com.emented.printingstudio.service

import com.emented.printingstudio.dto.AdministratorResponseDto

interface AdministratorService {
    fun administratorByUserId(userId: Long): AdministratorResponseDto?
}
