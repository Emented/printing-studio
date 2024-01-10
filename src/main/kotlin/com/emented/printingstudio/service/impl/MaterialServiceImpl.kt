package com.emented.printingstudio.service.impl

import com.emented.printingstudio.dao.MaterialDao
import com.emented.printingstudio.dto.MaterialResponseDto
import com.emented.printingstudio.extensions.toResponse
import com.emented.printingstudio.model.Material
import com.emented.printingstudio.service.MaterialService
import org.springframework.stereotype.Service

@Service
class MaterialServiceImpl(
    private val materialDao: MaterialDao,
) : MaterialService {
    override fun materials(): List<MaterialResponseDto> {
        val material = materialDao.getMaterials()

        return material.map(Material::toResponse)
    }
}
