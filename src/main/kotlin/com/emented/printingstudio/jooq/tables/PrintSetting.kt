/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables

import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.keys.PRINT_SETTING_PKEY
import com.emented.printingstudio.jooq.tables.records.PrintSettingRecord
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
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
import java.math.BigDecimal
import java.time.OffsetDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class PrintSetting(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, PrintSettingRecord>?,
    aliased: Table<PrintSettingRecord>?,
    parameters: Array<Field<*>?>?,
) : TableImpl<PrintSettingRecord>(
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
         * The reference instance of <code>public.print_setting</code>
         */
        val PRINT_SETTING = PrintSetting()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<PrintSettingRecord> = PrintSettingRecord::class.java

    /**
     * The column <code>public.print_setting.id</code>.
     */
    val ID: TableField<PrintSettingRecord, Long?> =
        createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.print_setting.description</code>.
     */
    val DESCRIPTION: TableField<PrintSettingRecord, String?> =
        createField(DSL.name("description"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.print_setting.price</code>.
     */
    val PRICE: TableField<PrintSettingRecord, BigDecimal?> =
        createField(DSL.name("price"), SQLDataType.NUMERIC(22, 2).nullable(false), this, "")

    /**
     * The column <code>public.print_setting.creation_timestamp</code>.
     */
    val CREATION_TIMESTAMP: TableField<PrintSettingRecord, OffsetDateTime?> =
        createField(DSL.name("creation_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.print_setting.update_timestamp</code>.
     */
    val UPDATE_TIMESTAMP: TableField<PrintSettingRecord, OffsetDateTime?> =
        createField(DSL.name("update_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<PrintSettingRecord>?) : this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<PrintSettingRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        aliased,
        parameters,
    )

    /**
     * Create an aliased <code>public.print_setting</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.print_setting</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.print_setting</code> table reference
     */
    constructor() : this(DSL.name("print_setting"), null)

    constructor(
        child: Table<out Record>,
        key: ForeignKey<out Record, PrintSettingRecord>,
    ) : this(Internal.createPathAlias(child, key), child, key, PRINT_SETTING, null)

    override fun getSchema(): Schema = Public.PUBLIC
    override fun getIdentity(): Identity<PrintSettingRecord, Long?> =
        super.getIdentity() as Identity<PrintSettingRecord, Long?>

    override fun getPrimaryKey(): UniqueKey<PrintSettingRecord> = PRINT_SETTING_PKEY
    override fun getKeys(): List<UniqueKey<PrintSettingRecord>> = listOf(PRINT_SETTING_PKEY)
    override fun `as`(alias: String): PrintSetting = PrintSetting(DSL.name(alias), this)
    override fun `as`(alias: Name): PrintSetting = PrintSetting(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): PrintSetting = PrintSetting(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): PrintSetting = PrintSetting(name, null)

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row5<Long?, String?, BigDecimal?, OffsetDateTime?, OffsetDateTime?> =
        super.fieldsRow() as Row5<Long?, String?, BigDecimal?, OffsetDateTime?, OffsetDateTime?>
}
