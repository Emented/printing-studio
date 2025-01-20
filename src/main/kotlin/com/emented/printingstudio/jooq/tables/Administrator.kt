/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables


import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.indexes.ADMINISTRATOR_USER_ID_INDEX
import com.emented.printingstudio.jooq.keys.ADMINISTRATOR_PKEY
import com.emented.printingstudio.jooq.keys.ADMINISTRATOR_USER_ID_KEY
import com.emented.printingstudio.jooq.keys.ADMINISTRATOR__ADMINISTRATOR_USER_ID_FKEY
import com.emented.printingstudio.jooq.keys.ORDER__ORDER_ADMINISTRATOR_ID_FKEY
import com.emented.printingstudio.jooq.tables.Order.OrderPath
import com.emented.printingstudio.jooq.tables.User.UserPath
import com.emented.printingstudio.jooq.tables.records.AdministratorRecord

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
open class Administrator(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, AdministratorRecord>?,
    parentPath: InverseForeignKey<out Record, AdministratorRecord>?,
    aliased: Table<AdministratorRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<AdministratorRecord>(
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
         * The reference instance of <code>public.administrator</code>
         */
        val ADMINISTRATOR: Administrator = Administrator()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<AdministratorRecord> = AdministratorRecord::class.java

    /**
     * The column <code>public.administrator.id</code>.
     */
    val ID: TableField<AdministratorRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.administrator.user_id</code>.
     */
    val USER_ID: TableField<AdministratorRecord, Long?> = createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.administrator.creation_timestamp</code>.
     */
    val CREATION_TIMESTAMP: TableField<AdministratorRecord, OffsetDateTime?> = createField(DSL.name("creation_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.administrator.update_timestamp</code>.
     */
    val UPDATE_TIMESTAMP: TableField<AdministratorRecord, OffsetDateTime?> = createField(DSL.name("update_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<AdministratorRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<AdministratorRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<AdministratorRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.administrator</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.administrator</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.administrator</code> table reference
     */
    constructor(): this(DSL.name("administrator"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, AdministratorRecord>?, parentPath: InverseForeignKey<out Record, AdministratorRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, ADMINISTRATOR, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class AdministratorPath : Administrator, Path<AdministratorRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, AdministratorRecord>?, parentPath: InverseForeignKey<out Record, AdministratorRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<AdministratorRecord>): super(alias, aliased)
        override fun `as`(alias: String): AdministratorPath = AdministratorPath(DSL.name(alias), this)
        override fun `as`(alias: Name): AdministratorPath = AdministratorPath(alias, this)
        override fun `as`(alias: Table<*>): AdministratorPath = AdministratorPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(ADMINISTRATOR_USER_ID_INDEX)
    override fun getIdentity(): Identity<AdministratorRecord, Long?> = super.getIdentity() as Identity<AdministratorRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<AdministratorRecord> = ADMINISTRATOR_PKEY
    override fun getUniqueKeys(): List<UniqueKey<AdministratorRecord>> = listOf(ADMINISTRATOR_USER_ID_KEY)
    override fun getReferences(): List<ForeignKey<AdministratorRecord, *>> = listOf(ADMINISTRATOR__ADMINISTRATOR_USER_ID_FKEY)

    private lateinit var _user: UserPath

    /**
     * Get the implicit join path to the <code>public.user</code> table.
     */
    fun user(): UserPath {
        if (!this::_user.isInitialized)
            _user = UserPath(this, ADMINISTRATOR__ADMINISTRATOR_USER_ID_FKEY, null)

        return _user;
    }

    val user: UserPath
        get(): UserPath = user()

    private lateinit var _order: OrderPath

    /**
     * Get the implicit to-many join path to the <code>public.order</code> table
     */
    fun order(): OrderPath {
        if (!this::_order.isInitialized)
            _order = OrderPath(this, null, ORDER__ORDER_ADMINISTRATOR_ID_FKEY.inverseKey)

        return _order;
    }

    val order: OrderPath
        get(): OrderPath = order()
    override fun `as`(alias: String): Administrator = Administrator(DSL.name(alias), this)
    override fun `as`(alias: Name): Administrator = Administrator(alias, this)
    override fun `as`(alias: Table<*>): Administrator = Administrator(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Administrator = Administrator(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Administrator = Administrator(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Administrator = Administrator(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Administrator = Administrator(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Administrator = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Administrator = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Administrator = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): Administrator = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): Administrator = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): Administrator = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): Administrator = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Administrator = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Administrator = where(DSL.notExists(select))
}
