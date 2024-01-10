/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables

import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.indexes.DELIVERY_TYPE_STATUS_INDEX
import com.emented.printingstudio.jooq.keys.DELIVERY_PKEY
import com.emented.printingstudio.jooq.keys.DELIVERY__DELIVERY_STATUS_FKEY
import com.emented.printingstudio.jooq.keys.DELIVERY__DELIVERY_TYPE_FKEY
import com.emented.printingstudio.jooq.tables.records.DeliveryRecord
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Index
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row5
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl
import java.time.OffsetDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Delivery(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, DeliveryRecord>?,
    aliased: Table<DeliveryRecord>?,
    parameters: Array<Field<*>?>?,
) : TableImpl<DeliveryRecord>(
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
         * The reference instance of <code>public.delivery</code>
         */
        val DELIVERY = Delivery()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<DeliveryRecord> = DeliveryRecord::class.java

    /**
     * The column <code>public.delivery.id</code>.
     */
    val ID: TableField<DeliveryRecord, Long?> =
        createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.delivery.type</code>.
     */
    val TYPE: TableField<DeliveryRecord, Long?> =
        createField(DSL.name("type"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.delivery.status</code>.
     */
    val STATUS: TableField<DeliveryRecord, Long?> =
        createField(DSL.name("status"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.delivery.creation_timestamp</code>.
     */
    val CREATION_TIMESTAMP: TableField<DeliveryRecord, OffsetDateTime?> =
        createField(DSL.name("creation_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.delivery.update_timestamp</code>.
     */
    val UPDATE_TIMESTAMP: TableField<DeliveryRecord, OffsetDateTime?> =
        createField(DSL.name("update_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<DeliveryRecord>?) : this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<DeliveryRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        aliased,
        parameters,
    )

    /**
     * Create an aliased <code>public.delivery</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.delivery</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.delivery</code> table reference
     */
    constructor() : this(DSL.name("delivery"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, DeliveryRecord>) : this(
        Internal.createPathAlias(
            child,
            key,
        ),
        child,
        key,
        DELIVERY,
        null,
    )

    override fun getSchema(): Schema = Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(DELIVERY_TYPE_STATUS_INDEX)
    override fun getIdentity(): Identity<DeliveryRecord, Long?> = super.getIdentity() as Identity<DeliveryRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<DeliveryRecord> = DELIVERY_PKEY
    override fun getKeys(): List<UniqueKey<DeliveryRecord>> = listOf(DELIVERY_PKEY)
    override fun getReferences(): List<ForeignKey<DeliveryRecord, *>> =
        listOf(DELIVERY__DELIVERY_TYPE_FKEY, DELIVERY__DELIVERY_STATUS_FKEY)

    private lateinit var _deliveryType: DeliveryType
    private lateinit var _deliveryStatus: DeliveryStatus
    fun deliveryType(): DeliveryType {
        if (!this::_deliveryType.isInitialized) {
            _deliveryType = DeliveryType(this, DELIVERY__DELIVERY_TYPE_FKEY)
        }

        return _deliveryType
    }

    fun deliveryStatus(): DeliveryStatus {
        if (!this::_deliveryStatus.isInitialized) {
            _deliveryStatus = DeliveryStatus(this, DELIVERY__DELIVERY_STATUS_FKEY)
        }

        return _deliveryStatus
    }

    override fun `as`(alias: String): Delivery = Delivery(DSL.name(alias), this)
    override fun `as`(alias: Name): Delivery = Delivery(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Delivery = Delivery(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Delivery = Delivery(name, null)

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row5<Long?, Long?, Long?, OffsetDateTime?, OffsetDateTime?> =
        super.fieldsRow() as Row5<Long?, Long?, Long?, OffsetDateTime?, OffsetDateTime?>
}