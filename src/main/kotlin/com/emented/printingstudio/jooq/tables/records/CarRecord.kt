/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables.records


import com.emented.printingstudio.jooq.tables.Car

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class CarRecord() : UpdatableRecordImpl<CarRecord>(Car.CAR) {

    open var id: Int?
        set(value): Unit = set(0, value)
        get(): Int? = get(0) as Int?

    open var name: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var clientId: Long?
        set(value): Unit = set(2, value)
        get(): Long? = get(2) as Long?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    /**
     * Create a detached, initialised CarRecord
     */
    constructor(id: Int? = null, name: String? = null, clientId: Long? = null): this() {
        this.id = id
        this.name = name
        this.clientId = clientId
        resetChangedOnNotNull()
    }
}
