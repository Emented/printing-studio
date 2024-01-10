/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables.records

import com.emented.printingstudio.jooq.tables.BusinessInfo
import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record6
import org.jooq.Row6
import org.jooq.impl.UpdatableRecordImpl
import java.time.OffsetDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class BusinessInfoRecord() :
    UpdatableRecordImpl<BusinessInfoRecord>(BusinessInfo.BUSINESS_INFO),
    Record6<Long?, String?, String?, String?, OffsetDateTime?, OffsetDateTime?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var inn: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var kpp: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var companyName: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var creationTimestamp: OffsetDateTime?
        set(value) = set(4, value)
        get() = get(4) as OffsetDateTime?

    var updateTimestamp: OffsetDateTime?
        set(value) = set(5, value)
        get() = get(5) as OffsetDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row6<Long?, String?, String?, String?, OffsetDateTime?, OffsetDateTime?> =
        super.fieldsRow() as Row6<Long?, String?, String?, String?, OffsetDateTime?, OffsetDateTime?>

    override fun valuesRow(): Row6<Long?, String?, String?, String?, OffsetDateTime?, OffsetDateTime?> =
        super.valuesRow() as Row6<Long?, String?, String?, String?, OffsetDateTime?, OffsetDateTime?>

    override fun field1(): Field<Long?> = BusinessInfo.BUSINESS_INFO.ID
    override fun field2(): Field<String?> = BusinessInfo.BUSINESS_INFO.INN
    override fun field3(): Field<String?> = BusinessInfo.BUSINESS_INFO.KPP
    override fun field4(): Field<String?> = BusinessInfo.BUSINESS_INFO.COMPANY_NAME
    override fun field5(): Field<OffsetDateTime?> = BusinessInfo.BUSINESS_INFO.CREATION_TIMESTAMP
    override fun field6(): Field<OffsetDateTime?> = BusinessInfo.BUSINESS_INFO.UPDATE_TIMESTAMP
    override fun component1(): Long? = id
    override fun component2(): String? = inn
    override fun component3(): String? = kpp
    override fun component4(): String? = companyName
    override fun component5(): OffsetDateTime? = creationTimestamp
    override fun component6(): OffsetDateTime? = updateTimestamp
    override fun value1(): Long? = id
    override fun value2(): String? = inn
    override fun value3(): String? = kpp
    override fun value4(): String? = companyName
    override fun value5(): OffsetDateTime? = creationTimestamp
    override fun value6(): OffsetDateTime? = updateTimestamp

    override fun value1(value: Long?): BusinessInfoRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): BusinessInfoRecord {
        this.inn = value
        return this
    }

    override fun value3(value: String?): BusinessInfoRecord {
        this.kpp = value
        return this
    }

    override fun value4(value: String?): BusinessInfoRecord {
        this.companyName = value
        return this
    }

    override fun value5(value: OffsetDateTime?): BusinessInfoRecord {
        this.creationTimestamp = value
        return this
    }

    override fun value6(value: OffsetDateTime?): BusinessInfoRecord {
        this.updateTimestamp = value
        return this
    }

    override fun values(
        value1: Long?,
        value2: String?,
        value3: String?,
        value4: String?,
        value5: OffsetDateTime?,
        value6: OffsetDateTime?,
    ): BusinessInfoRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        return this
    }

    /**
     * Create a detached, initialised BusinessInfoRecord
     */
    constructor(
        id: Long? = null,
        inn: String? = null,
        kpp: String? = null,
        companyName: String? = null,
        creationTimestamp: OffsetDateTime? = null,
        updateTimestamp: OffsetDateTime? = null,
    ) : this() {
        this.id = id
        this.inn = inn
        this.kpp = kpp
        this.companyName = companyName
        this.creationTimestamp = creationTimestamp
        this.updateTimestamp = updateTimestamp
    }
}