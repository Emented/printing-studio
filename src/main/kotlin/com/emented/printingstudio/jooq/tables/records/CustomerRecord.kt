/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables.records


import com.emented.printingstudio.jooq.tables.Customer

import java.time.OffsetDateTime

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class CustomerRecord() : UpdatableRecordImpl<CustomerRecord>(Customer.CUSTOMER) {

    open var id: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    open var userId: Long?
        set(value): Unit = set(1, value)
        get(): Long? = get(1) as Long?

    open var businessInfoId: Long?
        set(value): Unit = set(2, value)
        get(): Long? = get(2) as Long?

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
     * Create a detached, initialised CustomerRecord
     */
    constructor(id: Long? = null, userId: Long? = null, businessInfoId: Long? = null, creationTimestamp: OffsetDateTime? = null, updateTimestamp: OffsetDateTime? = null): this() {
        this.id = id
        this.userId = userId
        this.businessInfoId = businessInfoId
        this.creationTimestamp = creationTimestamp
        this.updateTimestamp = updateTimestamp
        resetChangedOnNotNull()
    }
}
