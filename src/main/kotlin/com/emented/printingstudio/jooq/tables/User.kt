/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables


import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.keys.ADMINISTRATOR__ADMINISTRATOR_USER_ID_FKEY
import com.emented.printingstudio.jooq.keys.CUSTOMER__CUSTOMER_USER_ID_FKEY
import com.emented.printingstudio.jooq.keys.USER_EMAIL_KEY
import com.emented.printingstudio.jooq.keys.USER_PKEY
import com.emented.printingstudio.jooq.keys.USER_USERNAME_KEY
import com.emented.printingstudio.jooq.tables.Administrator.AdministratorPath
import com.emented.printingstudio.jooq.tables.Customer.CustomerPath
import com.emented.printingstudio.jooq.tables.records.UserRecord

import java.time.OffsetDateTime

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
open class User(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, UserRecord>?,
    parentPath: InverseForeignKey<out Record, UserRecord>?,
    aliased: Table<UserRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<UserRecord>(
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
         * The reference instance of <code>public.user</code>
         */
        val USER: User = User()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<UserRecord> = UserRecord::class.java

    /**
     * The column <code>public.user.id</code>.
     */
    val ID: TableField<UserRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.user.username</code>.
     */
    val USERNAME: TableField<UserRecord, String?> = createField(DSL.name("username"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.user.password_hash</code>.
     */
    val PASSWORD_HASH: TableField<UserRecord, String?> = createField(DSL.name("password_hash"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.user.name</code>.
     */
    val NAME: TableField<UserRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.user.surname</code>.
     */
    val SURNAME: TableField<UserRecord, String?> = createField(DSL.name("surname"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.user.patronymic</code>.
     */
    val PATRONYMIC: TableField<UserRecord, String?> = createField(DSL.name("patronymic"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.user.phone</code>.
     */
    val PHONE: TableField<UserRecord, String?> = createField(DSL.name("phone"), SQLDataType.VARCHAR(20).nullable(false), this, "")

    /**
     * The column <code>public.user.email</code>.
     */
    val EMAIL: TableField<UserRecord, String?> = createField(DSL.name("email"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.user.address</code>.
     */
    val ADDRESS: TableField<UserRecord, String?> = createField(DSL.name("address"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.user.creation_timestamp</code>.
     */
    val CREATION_TIMESTAMP: TableField<UserRecord, OffsetDateTime?> = createField(DSL.name("creation_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.user.update_timestamp</code>.
     */
    val UPDATE_TIMESTAMP: TableField<UserRecord, OffsetDateTime?> = createField(DSL.name("update_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<UserRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<UserRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<UserRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.user</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.user</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.user</code> table reference
     */
    constructor(): this(DSL.name("user"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, UserRecord>?, parentPath: InverseForeignKey<out Record, UserRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, USER, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class UserPath : User, Path<UserRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, UserRecord>?, parentPath: InverseForeignKey<out Record, UserRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<UserRecord>): super(alias, aliased)
        override fun `as`(alias: String): UserPath = UserPath(DSL.name(alias), this)
        override fun `as`(alias: Name): UserPath = UserPath(alias, this)
        override fun `as`(alias: Table<*>): UserPath = UserPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<UserRecord, Long?> = super.getIdentity() as Identity<UserRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<UserRecord> = USER_PKEY
    override fun getUniqueKeys(): List<UniqueKey<UserRecord>> = listOf(USER_USERNAME_KEY, USER_EMAIL_KEY)

    private lateinit var _administrator: AdministratorPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.administrator</code> table
     */
    fun administrator(): AdministratorPath {
        if (!this::_administrator.isInitialized)
            _administrator = AdministratorPath(this, null, ADMINISTRATOR__ADMINISTRATOR_USER_ID_FKEY.inverseKey)

        return _administrator;
    }

    val administrator: AdministratorPath
        get(): AdministratorPath = administrator()

    private lateinit var _customer: CustomerPath

    /**
     * Get the implicit to-many join path to the <code>public.customer</code>
     * table
     */
    fun customer(): CustomerPath {
        if (!this::_customer.isInitialized)
            _customer = CustomerPath(this, null, CUSTOMER__CUSTOMER_USER_ID_FKEY.inverseKey)

        return _customer;
    }

    val customer: CustomerPath
        get(): CustomerPath = customer()
    override fun `as`(alias: String): User = User(DSL.name(alias), this)
    override fun `as`(alias: Name): User = User(alias, this)
    override fun `as`(alias: Table<*>): User = User(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): User = User(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): User = User(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): User = User(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): User = User(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): User = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): User = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): User = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): User = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): User = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): User = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): User = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): User = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): User = where(DSL.notExists(select))
}
