package com.emented.printingstudio.dao

import com.emented.printingstudio.jooq.tables.references.PRINT_SETTING
import com.emented.printingstudio.model.PrintSetting
import org.jooq.DSLContext
import org.jooq.Record
import org.springframework.stereotype.Repository

@Repository
class PrintSettingDao(
    private val dslContext: DSLContext,
) {

    fun getPrintSettingByDescription(name: String): PrintSetting? {
        return dslContext.select(printSettingFields)
            .from(PRINT_SETTING)
            .where(PRINT_SETTING.DESCRIPTION.eq(name))
            .fetchOne(PrintSettingDao::mapPrintSetting)
    }

    fun getPrintSettings(): List<PrintSetting> {
        return dslContext.select(printSettingFields)
            .from(PRINT_SETTING)
            .fetch(PrintSettingDao::mapPrintSetting)
    }

    companion object {
        val printSettingFields = setOf(
            PRINT_SETTING.ID,
            PRINT_SETTING.DESCRIPTION,
            PRINT_SETTING.PRICE,
            PRINT_SETTING.CREATION_TIMESTAMP,
            PRINT_SETTING.UPDATE_TIMESTAMP,
        )

        fun mapPrintSetting(record: Record): PrintSetting {
            return PrintSetting(
                id = record.get(PRINT_SETTING.ID)!!,
                description = record.get(PRINT_SETTING.DESCRIPTION)!!,
                price = record.get(PRINT_SETTING.PRICE)!!,
                creationTimestamp = record.get(PRINT_SETTING.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(PRINT_SETTING.UPDATE_TIMESTAMP)!!,
            )
        }
    }
}
