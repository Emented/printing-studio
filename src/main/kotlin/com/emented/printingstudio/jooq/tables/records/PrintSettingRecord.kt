/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables.records


import com.emented.printingstudio.jooq.tables.PrintSetting

import java.math.BigDecimal
import java.time.OffsetDateTime

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class PrintSettingRecord() : UpdatableRecordImpl<PrintSettingRecord>(PrintSetting.PRINT_SETTING) {

    open var id: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    open var description: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var price: BigDecimal?
        set(value): Unit = set(2, value)
        get(): BigDecimal? = get(2) as BigDecimal?

    open var creationTimestamp: OffsetDateTime?
        set(value): Unit = set(3, value)
        get(): OffsetDateTime? = get(3) as OffsetDateTime?

    open var updateTimestamp: OffsetDateTime?
        set(value): Unit = set(4, value)
        get(): OffsetDateTime? = get(4) as OffsetDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    /**
     * Create a detached, initialised PrintSettingRecord
     */
    constructor(id: Long? = null, description: String? = null, price: BigDecimal? = null, creationTimestamp: OffsetDateTime? = null, updateTimestamp: OffsetDateTime? = null): this() {
        this.id = id
        this.description = description
        this.price = price
        this.creationTimestamp = creationTimestamp
        this.updateTimestamp = updateTimestamp
        resetChangedOnNotNull()
    }
}
