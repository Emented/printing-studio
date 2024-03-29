/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables

import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.indexes.MATERIAL_TYPE_STATUS_INDEX
import com.emented.printingstudio.jooq.keys.MATERIAL_PKEY
import com.emented.printingstudio.jooq.keys.MATERIAL__MATERIAL_AVAILABILITY_STATUS_FKEY
import com.emented.printingstudio.jooq.keys.MATERIAL__MATERIAL_TYPE_FKEY
import com.emented.printingstudio.jooq.tables.records.MaterialRecord
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Index
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row9
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl
import java.math.BigDecimal
import java.time.OffsetDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Material(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, MaterialRecord>?,
    aliased: Table<MaterialRecord>?,
    parameters: Array<Field<*>?>?,
) : TableImpl<MaterialRecord>(
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
         * The reference instance of <code>public.material</code>
         */
        val MATERIAL = Material()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<MaterialRecord> = MaterialRecord::class.java

    /**
     * The column <code>public.material.id</code>.
     */
    val ID: TableField<MaterialRecord, Long?> =
        createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.material.type</code>.
     */
    val TYPE: TableField<MaterialRecord, Long?> =
        createField(DSL.name("type"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.material.availability_status</code>.
     */
    val AVAILABILITY_STATUS: TableField<MaterialRecord, Long?> =
        createField(DSL.name("availability_status"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.material.stock</code>.
     */
    val STOCK: TableField<MaterialRecord, Long?> =
        createField(DSL.name("stock"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.material.description</code>.
     */
    val DESCRIPTION: TableField<MaterialRecord, String?> =
        createField(DSL.name("description"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.material.price</code>.
     */
    val PRICE: TableField<MaterialRecord, BigDecimal?> =
        createField(DSL.name("price"), SQLDataType.NUMERIC(22, 2).nullable(false), this, "")

    /**
     * The column <code>public.material.color</code>.
     */
    val COLOR: TableField<MaterialRecord, String?> = createField(DSL.name("color"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.material.creation_timestamp</code>.
     */
    val CREATION_TIMESTAMP: TableField<MaterialRecord, OffsetDateTime?> =
        createField(DSL.name("creation_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.material.update_timestamp</code>.
     */
    val UPDATE_TIMESTAMP: TableField<MaterialRecord, OffsetDateTime?> =
        createField(DSL.name("update_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<MaterialRecord>?) : this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<MaterialRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        aliased,
        parameters,
    )

    /**
     * Create an aliased <code>public.material</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.material</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.material</code> table reference
     */
    constructor() : this(DSL.name("material"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, MaterialRecord>) : this(
        Internal.createPathAlias(
            child,
            key,
        ),
        child,
        key,
        MATERIAL,
        null,
    )

    override fun getSchema(): Schema = Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(MATERIAL_TYPE_STATUS_INDEX)
    override fun getIdentity(): Identity<MaterialRecord, Long?> = super.getIdentity() as Identity<MaterialRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<MaterialRecord> = MATERIAL_PKEY
    override fun getKeys(): List<UniqueKey<MaterialRecord>> = listOf(MATERIAL_PKEY)
    override fun getReferences(): List<ForeignKey<MaterialRecord, *>> =
        listOf(MATERIAL__MATERIAL_TYPE_FKEY, MATERIAL__MATERIAL_AVAILABILITY_STATUS_FKEY)

    private lateinit var _filamentType: FilamentType
    private lateinit var _availabilityStatus: AvailabilityStatus
    fun filamentType(): FilamentType {
        if (!this::_filamentType.isInitialized) {
            _filamentType = FilamentType(this, MATERIAL__MATERIAL_TYPE_FKEY)
        }

        return _filamentType
    }

    fun availabilityStatus(): AvailabilityStatus {
        if (!this::_availabilityStatus.isInitialized) {
            _availabilityStatus = AvailabilityStatus(this, MATERIAL__MATERIAL_AVAILABILITY_STATUS_FKEY)
        }

        return _availabilityStatus
    }

    override fun `as`(alias: String): Material = Material(DSL.name(alias), this)
    override fun `as`(alias: Name): Material = Material(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Material = Material(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Material = Material(name, null)

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row9<Long?, Long?, Long?, Long?, String?, BigDecimal?, String?, OffsetDateTime?, OffsetDateTime?> =
        super.fieldsRow() as Row9<Long?, Long?, Long?, Long?, String?, BigDecimal?, String?, OffsetDateTime?, OffsetDateTime?>
}
