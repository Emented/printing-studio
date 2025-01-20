/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables


import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.keys.PAYMENT_TYPE_PKEY
import com.emented.printingstudio.jooq.keys.PAYMENT_TYPE_VALUE_KEY
import com.emented.printingstudio.jooq.keys.PAYMENT__PAYMENT_TYPE_FKEY
import com.emented.printingstudio.jooq.tables.Payment.PaymentPath
import com.emented.printingstudio.jooq.tables.records.PaymentTypeRecord

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
open class PaymentType(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, PaymentTypeRecord>?,
    parentPath: InverseForeignKey<out Record, PaymentTypeRecord>?,
    aliased: Table<PaymentTypeRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<PaymentTypeRecord>(
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
         * The reference instance of <code>public.payment_type</code>
         */
        val PAYMENT_TYPE: PaymentType = PaymentType()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<PaymentTypeRecord> = PaymentTypeRecord::class.java

    /**
     * The column <code>public.payment_type.id</code>.
     */
    val ID: TableField<PaymentTypeRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.payment_type.value</code>.
     */
    val VALUE: TableField<PaymentTypeRecord, String?> = createField(DSL.name("value"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<PaymentTypeRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<PaymentTypeRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<PaymentTypeRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.payment_type</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.payment_type</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.payment_type</code> table reference
     */
    constructor(): this(DSL.name("payment_type"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, PaymentTypeRecord>?, parentPath: InverseForeignKey<out Record, PaymentTypeRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, PAYMENT_TYPE, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class PaymentTypePath : PaymentType, Path<PaymentTypeRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, PaymentTypeRecord>?, parentPath: InverseForeignKey<out Record, PaymentTypeRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<PaymentTypeRecord>): super(alias, aliased)
        override fun `as`(alias: String): PaymentTypePath = PaymentTypePath(DSL.name(alias), this)
        override fun `as`(alias: Name): PaymentTypePath = PaymentTypePath(alias, this)
        override fun `as`(alias: Table<*>): PaymentTypePath = PaymentTypePath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<PaymentTypeRecord, Long?> = super.getIdentity() as Identity<PaymentTypeRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<PaymentTypeRecord> = PAYMENT_TYPE_PKEY
    override fun getUniqueKeys(): List<UniqueKey<PaymentTypeRecord>> = listOf(PAYMENT_TYPE_VALUE_KEY)

    private lateinit var _payment: PaymentPath

    /**
     * Get the implicit to-many join path to the <code>public.payment</code>
     * table
     */
    fun payment(): PaymentPath {
        if (!this::_payment.isInitialized)
            _payment = PaymentPath(this, null, PAYMENT__PAYMENT_TYPE_FKEY.inverseKey)

        return _payment;
    }

    val payment: PaymentPath
        get(): PaymentPath = payment()
    override fun `as`(alias: String): PaymentType = PaymentType(DSL.name(alias), this)
    override fun `as`(alias: Name): PaymentType = PaymentType(alias, this)
    override fun `as`(alias: Table<*>): PaymentType = PaymentType(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): PaymentType = PaymentType(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): PaymentType = PaymentType(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): PaymentType = PaymentType(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): PaymentType = PaymentType(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): PaymentType = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): PaymentType = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): PaymentType = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): PaymentType = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): PaymentType = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): PaymentType = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): PaymentType = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): PaymentType = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): PaymentType = where(DSL.notExists(select))
}
