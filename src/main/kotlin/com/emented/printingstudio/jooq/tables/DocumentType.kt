/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables

import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.keys.DOCUMENT_TYPE_PKEY
import com.emented.printingstudio.jooq.keys.DOCUMENT_TYPE_VALUE_KEY
import com.emented.printingstudio.jooq.tables.records.DocumentTypeRecord
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
open class DocumentType(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, DocumentTypeRecord>?,
    aliased: Table<DocumentTypeRecord>?,
    parameters: Array<Field<*>?>?,
) : TableImpl<DocumentTypeRecord>(
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
         * The reference instance of <code>public.document_type</code>
         */
        val DOCUMENT_TYPE = DocumentType()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<DocumentTypeRecord> = DocumentTypeRecord::class.java

    /**
     * The column <code>public.document_type.id</code>.
     */
    val ID: TableField<DocumentTypeRecord, Long?> =
        createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.document_type.value</code>.
     */
    val VALUE: TableField<DocumentTypeRecord, String?> =
        createField(DSL.name("value"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<DocumentTypeRecord>?) : this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<DocumentTypeRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        aliased,
        parameters,
    )

    /**
     * Create an aliased <code>public.document_type</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.document_type</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.document_type</code> table reference
     */
    constructor() : this(DSL.name("document_type"), null)

    constructor(
        child: Table<out Record>,
        key: ForeignKey<out Record, DocumentTypeRecord>,
    ) : this(Internal.createPathAlias(child, key), child, key, DOCUMENT_TYPE, null)

    override fun getSchema(): Schema = Public.PUBLIC
    override fun getIdentity(): Identity<DocumentTypeRecord, Long?> =
        super.getIdentity() as Identity<DocumentTypeRecord, Long?>

    override fun getPrimaryKey(): UniqueKey<DocumentTypeRecord> = DOCUMENT_TYPE_PKEY
    override fun getKeys(): List<UniqueKey<DocumentTypeRecord>> = listOf(DOCUMENT_TYPE_PKEY, DOCUMENT_TYPE_VALUE_KEY)
    override fun `as`(alias: String): DocumentType = DocumentType(DSL.name(alias), this)
    override fun `as`(alias: Name): DocumentType = DocumentType(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): DocumentType = DocumentType(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): DocumentType = DocumentType(name, null)

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row2<Long?, String?> = super.fieldsRow() as Row2<Long?, String?>
}
