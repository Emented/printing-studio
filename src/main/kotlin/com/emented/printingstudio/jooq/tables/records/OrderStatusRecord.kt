/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables.records


import com.emented.printingstudio.jooq.tables.OrderStatus

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class OrderStatusRecord() : UpdatableRecordImpl<OrderStatusRecord>(OrderStatus.ORDER_STATUS) {

    open var id: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    open var value: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    /**
     * Create a detached, initialised OrderStatusRecord
     */
    constructor(id: Long? = null, value: String? = null): this() {
        this.id = id
        this.value = value
        resetChangedOnNotNull()
    }
}
