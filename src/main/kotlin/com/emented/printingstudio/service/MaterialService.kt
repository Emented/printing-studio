package com.emented.printingstudio.service

import com.emented.printingstudio.dto.MaterialResponseDto

interface MaterialService {

    fun materials(): List<MaterialResponseDto>
}
