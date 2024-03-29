/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables.records

import com.emented.printingstudio.jooq.tables.Material
import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record9
import org.jooq.Row9
import org.jooq.impl.UpdatableRecordImpl
import java.math.BigDecimal
import java.time.OffsetDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class MaterialRecord() :
    UpdatableRecordImpl<MaterialRecord>(Material.MATERIAL),
    Record9<Long?, Long?, Long?, Long?, String?, BigDecimal?, String?, OffsetDateTime?, OffsetDateTime?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var type: Long?
        set(value) = set(1, value)
        get() = get(1) as Long?

    var availabilityStatus: Long?
        set(value) = set(2, value)
        get() = get(2) as Long?

    var stock: Long?
        set(value) = set(3, value)
        get() = get(3) as Long?

    var description: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var price: BigDecimal?
        set(value) = set(5, value)
        get() = get(5) as BigDecimal?

    var color: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var creationTimestamp: OffsetDateTime?
        set(value) = set(7, value)
        get() = get(7) as OffsetDateTime?

    var updateTimestamp: OffsetDateTime?
        set(value) = set(8, value)
        get() = get(8) as OffsetDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row9<Long?, Long?, Long?, Long?, String?, BigDecimal?, String?, OffsetDateTime?, OffsetDateTime?> =
        super.fieldsRow() as Row9<Long?, Long?, Long?, Long?, String?, BigDecimal?, String?, OffsetDateTime?, OffsetDateTime?>

    override fun valuesRow(): Row9<Long?, Long?, Long?, Long?, String?, BigDecimal?, String?, OffsetDateTime?, OffsetDateTime?> =
        super.valuesRow() as Row9<Long?, Long?, Long?, Long?, String?, BigDecimal?, String?, OffsetDateTime?, OffsetDateTime?>

    override fun field1(): Field<Long?> = Material.MATERIAL.ID
    override fun field2(): Field<Long?> = Material.MATERIAL.TYPE
    override fun field3(): Field<Long?> = Material.MATERIAL.AVAILABILITY_STATUS
    override fun field4(): Field<Long?> = Material.MATERIAL.STOCK
    override fun field5(): Field<String?> = Material.MATERIAL.DESCRIPTION
    override fun field6(): Field<BigDecimal?> = Material.MATERIAL.PRICE
    override fun field7(): Field<String?> = Material.MATERIAL.COLOR
    override fun field8(): Field<OffsetDateTime?> = Material.MATERIAL.CREATION_TIMESTAMP
    override fun field9(): Field<OffsetDateTime?> = Material.MATERIAL.UPDATE_TIMESTAMP
    override fun component1(): Long? = id
    override fun component2(): Long? = type
    override fun component3(): Long? = availabilityStatus
    override fun component4(): Long? = stock
    override fun component5(): String? = description
    override fun component6(): BigDecimal? = price
    override fun component7(): String? = color
    override fun component8(): OffsetDateTime? = creationTimestamp
    override fun component9(): OffsetDateTime? = updateTimestamp
    override fun value1(): Long? = id
    override fun value2(): Long? = type
    override fun value3(): Long? = availabilityStatus
    override fun value4(): Long? = stock
    override fun value5(): String? = description
    override fun value6(): BigDecimal? = price
    override fun value7(): String? = color
    override fun value8(): OffsetDateTime? = creationTimestamp
    override fun value9(): OffsetDateTime? = updateTimestamp

    override fun value1(value: Long?): MaterialRecord {
        this.id = value
        return this
    }

    override fun value2(value: Long?): MaterialRecord {
        this.type = value
        return this
    }

    override fun value3(value: Long?): MaterialRecord {
        this.availabilityStatus = value
        return this
    }

    override fun value4(value: Long?): MaterialRecord {
        this.stock = value
        return this
    }

    override fun value5(value: String?): MaterialRecord {
        this.description = value
        return this
    }

    override fun value6(value: BigDecimal?): MaterialRecord {
        this.price = value
        return this
    }

    override fun value7(value: String?): MaterialRecord {
        this.color = value
        return this
    }

    override fun value8(value: OffsetDateTime?): MaterialRecord {
        this.creationTimestamp = value
        return this
    }

    override fun value9(value: OffsetDateTime?): MaterialRecord {
        this.updateTimestamp = value
        return this
    }

    override fun values(
        value1: Long?,
        value2: Long?,
        value3: Long?,
        value4: Long?,
        value5: String?,
        value6: BigDecimal?,
        value7: String?,
        value8: OffsetDateTime?,
        value9: OffsetDateTime?,
    ): MaterialRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        this.value9(value9)
        return this
    }

    /**
     * Create a detached, initialised MaterialRecord
     */
    constructor(
        id: Long? = null,
        type: Long? = null,
        availabilityStatus: Long? = null,
        stock: Long? = null,
        description: String? = null,
        price: BigDecimal? = null,
        color: String? = null,
        creationTimestamp: OffsetDateTime? = null,
        updateTimestamp: OffsetDateTime? = null,
    ) : this() {
        this.id = id
        this.type = type
        this.availabilityStatus = availabilityStatus
        this.stock = stock
        this.description = description
        this.price = price
        this.color = color
        this.creationTimestamp = creationTimestamp
        this.updateTimestamp = updateTimestamp
    }
}
