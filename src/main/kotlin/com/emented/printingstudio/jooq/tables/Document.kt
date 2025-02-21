/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables


import com.emented.printingstudio.jooq.Public
import com.emented.printingstudio.jooq.indexes.DOCUMENT_ORDER_ID_INDEX
import com.emented.printingstudio.jooq.keys.DOCUMENT_PKEY
import com.emented.printingstudio.jooq.keys.DOCUMENT__DOCUMENT_ORDER_ID_FKEY
import com.emented.printingstudio.jooq.keys.DOCUMENT__DOCUMENT_TYPE_FKEY
import com.emented.printingstudio.jooq.tables.DocumentType.DocumentTypePath
import com.emented.printingstudio.jooq.tables.Order.OrderPath
import com.emented.printingstudio.jooq.tables.records.DocumentRecord

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
open class Document(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, DocumentRecord>?,
    parentPath: InverseForeignKey<out Record, DocumentRecord>?,
    aliased: Table<DocumentRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<DocumentRecord>(
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
         * The reference instance of <code>public.document</code>
         */
        val DOCUMENT: Document = Document()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<DocumentRecord> = DocumentRecord::class.java

    /**
     * The column <code>public.document.id</code>.
     */
    val ID: TableField<DocumentRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.document.type</code>.
     */
    val TYPE: TableField<DocumentRecord, Long?> = createField(DSL.name("type"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.document.url</code>.
     */
    val URL: TableField<DocumentRecord, String?> = createField(DSL.name("url"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.document.order_id</code>.
     */
    val ORDER_ID: TableField<DocumentRecord, Long?> = createField(DSL.name("order_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.document.creation_timestamp</code>.
     */
    val CREATION_TIMESTAMP: TableField<DocumentRecord, OffsetDateTime?> = createField(DSL.name("creation_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.document.update_timestamp</code>.
     */
    val UPDATE_TIMESTAMP: TableField<DocumentRecord, OffsetDateTime?> = createField(DSL.name("update_timestamp"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<DocumentRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<DocumentRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<DocumentRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.document</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.document</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.document</code> table reference
     */
    constructor(): this(DSL.name("document"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, DocumentRecord>?, parentPath: InverseForeignKey<out Record, DocumentRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, DOCUMENT, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class DocumentPath : Document, Path<DocumentRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, DocumentRecord>?, parentPath: InverseForeignKey<out Record, DocumentRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<DocumentRecord>): super(alias, aliased)
        override fun `as`(alias: String): DocumentPath = DocumentPath(DSL.name(alias), this)
        override fun `as`(alias: Name): DocumentPath = DocumentPath(alias, this)
        override fun `as`(alias: Table<*>): DocumentPath = DocumentPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(DOCUMENT_ORDER_ID_INDEX)
    override fun getIdentity(): Identity<DocumentRecord, Long?> = super.getIdentity() as Identity<DocumentRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<DocumentRecord> = DOCUMENT_PKEY
    override fun getReferences(): List<ForeignKey<DocumentRecord, *>> = listOf(DOCUMENT__DOCUMENT_TYPE_FKEY, DOCUMENT__DOCUMENT_ORDER_ID_FKEY)

    private lateinit var _documentType: DocumentTypePath

    /**
     * Get the implicit join path to the <code>public.document_type</code>
     * table.
     */
    fun documentType(): DocumentTypePath {
        if (!this::_documentType.isInitialized)
            _documentType = DocumentTypePath(this, DOCUMENT__DOCUMENT_TYPE_FKEY, null)

        return _documentType;
    }

    val documentType: DocumentTypePath
        get(): DocumentTypePath = documentType()

    private lateinit var _order: OrderPath

    /**
     * Get the implicit join path to the <code>public.order</code> table.
     */
    fun order(): OrderPath {
        if (!this::_order.isInitialized)
            _order = OrderPath(this, DOCUMENT__DOCUMENT_ORDER_ID_FKEY, null)

        return _order;
    }

    val order: OrderPath
        get(): OrderPath = order()
    override fun `as`(alias: String): Document = Document(DSL.name(alias), this)
    override fun `as`(alias: Name): Document = Document(alias, this)
    override fun `as`(alias: Table<*>): Document = Document(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Document = Document(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Document = Document(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Document = Document(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Document = Document(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Document = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Document = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Document = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): Document = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): Document = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): Document = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): Document = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Document = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Document = where(DSL.notExists(select))
}
