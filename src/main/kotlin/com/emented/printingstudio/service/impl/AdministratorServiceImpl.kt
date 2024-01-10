package com.emented.printingstudio.service.impl

import com.emented.printingstudio.dao.AdministratorDao
import com.emented.printingstudio.dto.AdministratorResponseDto
import com.emented.printingstudio.extensions.toResponse
import com.emented.printingstudio.service.AdministratorService
import org.springframework.stereotype.Service

@Service
class AdministratorServiceImpl(
    private val administratorDao: AdministratorDao,
) : AdministratorService {
    override fun administratorByUserId(userId: Long): AdministratorResponseDto? {
        val administrator = administratorDao.getAdministratorByUserId(userId)

        return administrator?.toResponse()
    }
}
