package com.emented.printingstudio.service.impl

import com.emented.printingstudio.dao.PrintSettingDao
import com.emented.printingstudio.dto.PrintSettingResponseDto
import com.emented.printingstudio.extensions.toResponse
import com.emented.printingstudio.model.PrintSetting
import com.emented.printingstudio.service.PrintSettingService
import org.springframework.stereotype.Service

@Service
class PrintSettingServiceImpl(
    private val printSettingDao: PrintSettingDao,
) : PrintSettingService {
    override fun printSettings(): List<PrintSettingResponseDto> {
        val printSettings = printSettingDao.getPrintSettings()

        return printSettings.map(PrintSetting::toResponse)
    }
}
