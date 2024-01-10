/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables

import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.keys.PAYMENT_TYPE_PKEY
import com.emented.printingstudio.jooq.keys.PAYMENT_TYPE_VALUE_KEY
import com.emented.printingstudio.jooq.tables.records.PaymentTypeRecord
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
open class PaymentType(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, PaymentTypeRecord>?,
    aliased: Table<PaymentTypeRecord>?,
    parameters: Array<Field<*>?>?,
) : TableImpl<PaymentTypeRecord>(
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
         * The reference instance of <code>public.payment_type</code>
         */
        val PAYMENT_TYPE = PaymentType()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<PaymentTypeRecord> = PaymentTypeRecord::class.java

    /**
     * The column <code>public.payment_type.id</code>.
     */
    val ID: TableField<PaymentTypeRecord, Long?> =
        createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.payment_type.value</code>.
     */
    val VALUE: TableField<PaymentTypeRecord, String?> =
        createField(DSL.name("value"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<PaymentTypeRecord>?) : this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<PaymentTypeRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        aliased,
        parameters,
    )

    /**
     * Create an aliased <code>public.payment_type</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.payment_type</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.payment_type</code> table reference
     */
    constructor() : this(DSL.name("payment_type"), null)

    constructor(
        child: Table<out Record>,
        key: ForeignKey<out Record, PaymentTypeRecord>,
    ) : this(Internal.createPathAlias(child, key), child, key, PAYMENT_TYPE, null)

    override fun getSchema(): Schema = Public.PUBLIC
    override fun getIdentity(): Identity<PaymentTypeRecord, Long?> =
        super.getIdentity() as Identity<PaymentTypeRecord, Long?>

    override fun getPrimaryKey(): UniqueKey<PaymentTypeRecord> = PAYMENT_TYPE_PKEY
    override fun getKeys(): List<UniqueKey<PaymentTypeRecord>> = listOf(PAYMENT_TYPE_PKEY, PAYMENT_TYPE_VALUE_KEY)
    override fun `as`(alias: String): PaymentType = PaymentType(DSL.name(alias), this)
    override fun `as`(alias: Name): PaymentType = PaymentType(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): PaymentType = PaymentType(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): PaymentType = PaymentType(name, null)

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row2<Long?, String?> = super.fieldsRow() as Row2<Long?, String?>
}
