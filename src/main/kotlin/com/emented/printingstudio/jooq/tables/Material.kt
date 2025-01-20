/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables


import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.indexes.MATERIAL_TYPE_STATUS_INDEX
import com.emented.printingstudio.jooq.keys.MATERIAL_PKEY
import com.emented.printingstudio.jooq.keys.MATERIAL__MATERIAL_AVAILABILITY_STATUS_FKEY
import com.emented.printingstudio.jooq.keys.MATERIAL__MATERIAL_TYPE_FKEY
import com.emented.printingstudio.jooq.keys.ORDER__ORDER_MATERIAL_ID_FKEY
import com.emented.printingstudio.jooq.tables.AvailabilityStatus.AvailabilityStatusPath
import com.emented.printingstudio.jooq.tables.FilamentType.FilamentTypePath
import com.emented.printingstudio.jooq.tables.Order.OrderPath
import com.emented.printingstudio.jooq.tables.records.MaterialRecord

import java.math.BigDecimal
import java.time.OffsetDateTime

import kotlin.collections.Collection
import kotlin.collections.List

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Index
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.Path
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
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
open class Material(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, MaterialRecord>?,
    parentPath: InverseForeignKey<out Record, MaterialRecord>?,
    aliased: Table<MaterialRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<MaterialRecord>(
    alias,
    Public.PUBLIC,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
) {
    companion object {

        /**
         * The reference instance of <code>public.material</code>
         */
        val MATERIAL: Material = Material()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<MaterialRecord> = MaterialRecord::class.java

    /**
     * The column <code>public.material.id</code>.
     */
    val ID: TableField<MaterialRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.material.type</code>.
     */
    val TYPE: TableField<MaterialRecord, Long?> = createField(DSL.name("type"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.material.availability_status</code>.
     */
    val AVAILABILITY_STATUS: TableField<MaterialRecord, Long?> = createField(DSL.name("availability_status"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.material.stock</code>.
     */
    val STOCK: TableField<MaterialRecord, Long?> = createField(DSL.name("stock"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.material.description</code>.
     */
    val DESCRIPTION: TableField<MaterialRecord, String?> = createField(DSL.name("description"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.material.price</code>.
     */
    val PRICE: TableField<MaterialRecord, BigDecimal?> = createField(DSL.name("price"), SQLDataType.NUMERIC(22, 2).nullable(false), this, "")

    /**
     * The column <code>public.material.color</code>.
     */
    val COLOR: TableField<MaterialRecord, String?> = createField(DSL.name("color"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.material.creation_timestamp</code>.
     */
    val CREATION_TIMESTAMP: TableField<MaterialRecord, OffsetDateTime?> = createField(DSL.name("creation_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.material.update_timestamp</code>.
     */
    val UPDATE_TIMESTAMP: TableField<MaterialRecord, OffsetDateTime?> = createField(DSL.name("update_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<MaterialRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<MaterialRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<MaterialRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.material</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.material</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.material</code> table reference
     */
    constructor(): this(DSL.name("material"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, MaterialRecord>?, parentPath: InverseForeignKey<out Record, MaterialRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, MATERIAL, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class MaterialPath : Material, Path<MaterialRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, MaterialRecord>?, parentPath: InverseForeignKey<out Record, MaterialRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<MaterialRecord>): super(alias, aliased)
        override fun `as`(alias: String): MaterialPath = MaterialPath(DSL.name(alias), this)
        override fun `as`(alias: Name): MaterialPath = MaterialPath(alias, this)
        override fun `as`(alias: Table<*>): MaterialPath = MaterialPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(MATERIAL_TYPE_STATUS_INDEX)
    override fun getIdentity(): Identity<MaterialRecord, Long?> = super.getIdentity() as Identity<MaterialRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<MaterialRecord> = MATERIAL_PKEY
    override fun getReferences(): List<ForeignKey<MaterialRecord, *>> = listOf(MATERIAL__MATERIAL_TYPE_FKEY, MATERIAL__MATERIAL_AVAILABILITY_STATUS_FKEY)

    private lateinit var _filamentType: FilamentTypePath

    /**
     * Get the implicit join path to the <code>public.filament_type</code>
     * table.
     */
    fun filamentType(): FilamentTypePath {
        if (!this::_filamentType.isInitialized)
            _filamentType = FilamentTypePath(this, MATERIAL__MATERIAL_TYPE_FKEY, null)

        return _filamentType;
    }

    val filamentType: FilamentTypePath
        get(): FilamentTypePath = filamentType()

    private lateinit var _availabilityStatus: AvailabilityStatusPath

    /**
     * Get the implicit join path to the <code>public.availability_status</code>
     * table.
     */
    fun availabilityStatus(): AvailabilityStatusPath {
        if (!this::_availabilityStatus.isInitialized)
            _availabilityStatus = AvailabilityStatusPath(this, MATERIAL__MATERIAL_AVAILABILITY_STATUS_FKEY, null)

        return _availabilityStatus;
    }

    val availabilityStatus: AvailabilityStatusPath
        get(): AvailabilityStatusPath = availabilityStatus()

    private lateinit var _order: OrderPath

    /**
     * Get the implicit to-many join path to the <code>public.order</code> table
     */
    fun order(): OrderPath {
        if (!this::_order.isInitialized)
            _order = OrderPath(this, null, ORDER__ORDER_MATERIAL_ID_FKEY.inverseKey)

        return _order;
    }

    val order: OrderPath
        get(): OrderPath = order()
    override fun `as`(alias: String): Material = Material(DSL.name(alias), this)
    override fun `as`(alias: Name): Material = Material(alias, this)
    override fun `as`(alias: Table<*>): Material = Material(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Material = Material(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Material = Material(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Material = Material(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Material = Material(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Material = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Material = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Material = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): Material = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): Material = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): Material = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): Material = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Material = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Material = where(DSL.notExists(select))
}
