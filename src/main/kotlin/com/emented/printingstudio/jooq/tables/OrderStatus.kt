/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables


import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.keys.ORDER_STATUS_PKEY
import com.emented.printingstudio.jooq.keys.ORDER_STATUS_VALUE_KEY
import com.emented.printingstudio.jooq.keys.ORDER__ORDER_STATUS_FKEY
import com.emented.printingstudio.jooq.tables.Order.OrderPath
import com.emented.printingstudio.jooq.tables.records.OrderStatusRecord

import kotlin.collections.Collection
import kotlin.collections.List

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
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
open class OrderStatus(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, OrderStatusRecord>?,
    parentPath: InverseForeignKey<out Record, OrderStatusRecord>?,
    aliased: Table<OrderStatusRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<OrderStatusRecord>(
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
         * The reference instance of <code>public.order_status</code>
         */
        val ORDER_STATUS: OrderStatus = OrderStatus()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<OrderStatusRecord> = OrderStatusRecord::class.java

    /**
     * The column <code>public.order_status.id</code>.
     */
    val ID: TableField<OrderStatusRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.order_status.value</code>.
     */
    val VALUE: TableField<OrderStatusRecord, String?> = createField(DSL.name("value"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<OrderStatusRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<OrderStatusRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<OrderStatusRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.order_status</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.order_status</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.order_status</code> table reference
     */
    constructor(): this(DSL.name("order_status"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, OrderStatusRecord>?, parentPath: InverseForeignKey<out Record, OrderStatusRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, ORDER_STATUS, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class OrderStatusPath : OrderStatus, Path<OrderStatusRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, OrderStatusRecord>?, parentPath: InverseForeignKey<out Record, OrderStatusRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<OrderStatusRecord>): super(alias, aliased)
        override fun `as`(alias: String): OrderStatusPath = OrderStatusPath(DSL.name(alias), this)
        override fun `as`(alias: Name): OrderStatusPath = OrderStatusPath(alias, this)
        override fun `as`(alias: Table<*>): OrderStatusPath = OrderStatusPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<OrderStatusRecord, Long?> = super.getIdentity() as Identity<OrderStatusRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<OrderStatusRecord> = ORDER_STATUS_PKEY
    override fun getUniqueKeys(): List<UniqueKey<OrderStatusRecord>> = listOf(ORDER_STATUS_VALUE_KEY)

    private lateinit var _order: OrderPath

    /**
     * Get the implicit to-many join path to the <code>public.order</code> table
     */
    fun order(): OrderPath {
        if (!this::_order.isInitialized)
            _order = OrderPath(this, null, ORDER__ORDER_STATUS_FKEY.inverseKey)

        return _order;
    }

    val order: OrderPath
        get(): OrderPath = order()
    override fun `as`(alias: String): OrderStatus = OrderStatus(DSL.name(alias), this)
    override fun `as`(alias: Name): OrderStatus = OrderStatus(alias, this)
    override fun `as`(alias: Table<*>): OrderStatus = OrderStatus(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): OrderStatus = OrderStatus(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): OrderStatus = OrderStatus(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): OrderStatus = OrderStatus(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): OrderStatus = OrderStatus(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): OrderStatus = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): OrderStatus = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): OrderStatus = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): OrderStatus = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): OrderStatus = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): OrderStatus = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): OrderStatus = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): OrderStatus = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): OrderStatus = where(DSL.notExists(select))
}
