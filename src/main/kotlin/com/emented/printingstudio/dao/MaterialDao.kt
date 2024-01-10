package com.emented.printingstudio.dao

import com.emented.printingstudio.jooq.tables.references.AVAILABILITY_STATUS
import com.emented.printingstudio.jooq.tables.references.FILAMENT_TYPE
import com.emented.printingstudio.jooq.tables.references.MATERIAL
import com.emented.printingstudio.model.Material
import com.emented.printingstudio.model.enums.AvailabilityStatus
import com.emented.printingstudio.model.enums.FilamentType
import org.jooq.DSLContext
import org.jooq.Record
import org.springframework.stereotype.Repository

@Repository
class MaterialDao(
    private val dslContext: DSLContext,
) {

    fun getMaterialByFilamentType(name: String): Material? {
        return dslContext.select(materialFields)
            .from(MATERIAL)
            .join(FILAMENT_TYPE).on(MATERIAL.TYPE.eq(FILAMENT_TYPE.ID))
            .join(AVAILABILITY_STATUS).on(MATERIAL.AVAILABILITY_STATUS.eq(AVAILABILITY_STATUS.ID))
            .where(FILAMENT_TYPE.VALUE.eq(name))
            .fetchOne(MaterialDao::mapMaterial)
    }

    fun getMaterials(): List<Material> {
        return dslContext.select(materialFields)
            .from(MATERIAL)
            .join(FILAMENT_TYPE).on(MATERIAL.TYPE.eq(FILAMENT_TYPE.ID))
            .join(AVAILABILITY_STATUS).on(MATERIAL.AVAILABILITY_STATUS.eq(AVAILABILITY_STATUS.ID))
            .fetch(MaterialDao::mapMaterial)
    }

    companion object {
        val materialFields = setOf(
            MATERIAL.ID,
            FILAMENT_TYPE.VALUE,
            AVAILABILITY_STATUS.VALUE,
            MATERIAL.STOCK,
            MATERIAL.DESCRIPTION,
            MATERIAL.PRICE,
            MATERIAL.COLOR,
            MATERIAL.CREATION_TIMESTAMP,
            MATERIAL.UPDATE_TIMESTAMP,
        )

        fun mapMaterial(record: Record): Material {
            return Material(
                id = record.get(MATERIAL.ID)!!,
                type = FilamentType.valueOf(record.get(FILAMENT_TYPE.VALUE)!!),
                availabilityStatus = AvailabilityStatus.valueOf(record.get(AVAILABILITY_STATUS.VALUE)!!),
                stock = record.get(MATERIAL.STOCK)!!,
                description = record.get(MATERIAL.DESCRIPTION)!!,
                price = record.get(MATERIAL.PRICE)!!,
                color = record.get(MATERIAL.COLOR)!!,
                creationTimestamp = record.get(MATERIAL.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(MATERIAL.UPDATE_TIMESTAMP)!!,
            )
        }
    }
}
