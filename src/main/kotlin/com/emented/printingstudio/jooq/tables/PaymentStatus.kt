/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables

import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.keys.PAYMENT_STATUS_PKEY
import com.emented.printingstudio.jooq.keys.PAYMENT_STATUS_VALUE_KEY
import com.emented.printingstudio.jooq.tables.records.PaymentStatusRecord
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row2
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class PaymentStatus(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, PaymentStatusRecord>?,
    aliased: Table<PaymentStatusRecord>?,
    parameters: Array<Field<*>?>?,
) : TableImpl<PaymentStatusRecord>(
    alias,
    Public.PUBLIC,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
) {
    companion object {

        /**
         * The reference instance of <code>public.payment_status</code>
         */
        val PAYMENT_STATUS = PaymentStatus()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<PaymentStatusRecord> = PaymentStatusRecord::class.java

    /**
     * The column <code>public.payment_status.id</code>.
     */
    val ID: TableField<PaymentStatusRecord, Long?> =
        createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.payment_status.value</code>.
     */
    val VALUE: TableField<PaymentStatusRecord, String?> =
        createField(DSL.name("value"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<PaymentStatusRecord>?) : this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<PaymentStatusRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        aliased,
        parameters,
    )

    /**
     * Create an aliased <code>public.payment_status</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.payment_status</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.payment_status</code> table reference
     */
    constructor() : this(DSL.name("payment_status"), null)

    constructor(
        child: Table<out Record>,
        key: ForeignKey<out Record, PaymentStatusRecord>,
    ) : this(Internal.createPathAlias(child, key), child, key, PAYMENT_STATUS, null)

    override fun getSchema(): Schema = Public.PUBLIC
    override fun getIdentity(): Identity<PaymentStatusRecord, Long?> =
        super.getIdentity() as Identity<PaymentStatusRecord, Long?>

    override fun getPrimaryKey(): UniqueKey<PaymentStatusRecord> = PAYMENT_STATUS_PKEY
    override fun getKeys(): List<UniqueKey<PaymentStatusRecord>> = listOf(PAYMENT_STATUS_PKEY, PAYMENT_STATUS_VALUE_KEY)
    override fun `as`(alias: String): PaymentStatus = PaymentStatus(DSL.name(alias), this)
    override fun `as`(alias: Name): PaymentStatus = PaymentStatus(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): PaymentStatus = PaymentStatus(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): PaymentStatus = PaymentStatus(name, null)

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row2<Long?, String?> = super.fieldsRow() as Row2<Long?, String?>
}
