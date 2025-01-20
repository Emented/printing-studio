/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables.records


import com.emented.printingstudio.jooq.tables.Material

import java.math.BigDecimal
import java.time.OffsetDateTime

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class MaterialRecord() : UpdatableRecordImpl<MaterialRecord>(Material.MATERIAL) {

    open var id: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    open var type: Long?
        set(value): Unit = set(1, value)
        get(): Long? = get(1) as Long?

    open var availabilityStatus: Long?
        set(value): Unit = set(2, value)
        get(): Long? = get(2) as Long?

    open var stock: Long?
        set(value): Unit = set(3, value)
        get(): Long? = get(3) as Long?

    open var description: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var price: BigDecimal?
        set(value): Unit = set(5, value)
        get(): BigDecimal? = get(5) as BigDecimal?

    open var color: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    open var creationTimestamp: OffsetDateTime?
        set(value): Unit = set(7, value)
        get(): OffsetDateTime? = get(7) as OffsetDateTime?

    open var updateTimestamp: OffsetDateTime?
        set(value): Unit = set(8, value)
        get(): OffsetDateTime? = get(8) as OffsetDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    /**
     * Create a detached, initialised MaterialRecord
     */
    constructor(id: Long? = null, type: Long? = null, availabilityStatus: Long? = null, stock: Long? = null, description: String? = null, price: BigDecimal? = null, color: String? = null, creationTimestamp: OffsetDateTime? = null, updateTimestamp: OffsetDateTime? = null): this() {
        this.id = id
        this.type = type
        this.availabilityStatus = availabilityStatus
        this.stock = stock
        this.description = description
        this.price = price
        this.color = color
        this.creationTimestamp = creationTimestamp
        this.updateTimestamp = updateTimestamp
        resetChangedOnNotNull()
    }
}
