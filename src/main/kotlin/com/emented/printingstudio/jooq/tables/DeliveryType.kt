/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables

import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.keys.DELIVERY_TYPE_PKEY
import com.emented.printingstudio.jooq.keys.DELIVERY_TYPE_VALUE_KEY
import com.emented.printingstudio.jooq.tables.records.DeliveryTypeRecord
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
open class DeliveryType(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, DeliveryTypeRecord>?,
    aliased: Table<DeliveryTypeRecord>?,
    parameters: Array<Field<*>?>?,
) : TableImpl<DeliveryTypeRecord>(
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
         * The reference instance of <code>public.delivery_type</code>
         */
        val DELIVERY_TYPE = DeliveryType()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<DeliveryTypeRecord> = DeliveryTypeRecord::class.java

    /**
     * The column <code>public.delivery_type.id</code>.
     */
    val ID: TableField<DeliveryTypeRecord, Long?> =
        createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.delivery_type.value</code>.
     */
    val VALUE: TableField<DeliveryTypeRecord, String?> =
        createField(DSL.name("value"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<DeliveryTypeRecord>?) : this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<DeliveryTypeRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        aliased,
        parameters,
    )

    /**
     * Create an aliased <code>public.delivery_type</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.delivery_type</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.delivery_type</code> table reference
     */
    constructor() : this(DSL.name("delivery_type"), null)

    constructor(
        child: Table<out Record>,
        key: ForeignKey<out Record, DeliveryTypeRecord>,
    ) : this(Internal.createPathAlias(child, key), child, key, DELIVERY_TYPE, null)

    override fun getSchema(): Schema = Public.PUBLIC
    override fun getIdentity(): Identity<DeliveryTypeRecord, Long?> =
        super.getIdentity() as Identity<DeliveryTypeRecord, Long?>

    override fun getPrimaryKey(): UniqueKey<DeliveryTypeRecord> = DELIVERY_TYPE_PKEY
    override fun getKeys(): List<UniqueKey<DeliveryTypeRecord>> = listOf(DELIVERY_TYPE_PKEY, DELIVERY_TYPE_VALUE_KEY)
    override fun `as`(alias: String): DeliveryType = DeliveryType(DSL.name(alias), this)
    override fun `as`(alias: Name): DeliveryType = DeliveryType(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): DeliveryType = DeliveryType(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): DeliveryType = DeliveryType(name, null)

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row2<Long?, String?> = super.fieldsRow() as Row2<Long?, String?>
}
