package com.emented.printingstudio.dao

import com.emented.printingstudio.jooq.tables.references.DOCUMENT
import com.emented.printingstudio.jooq.tables.references.DOCUMENT_TYPE
import com.emented.printingstudio.model.Document
import com.emented.printingstudio.model.enums.DocumentType
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.impl.DSL.select
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class DocumentDao(
    private val dslContext: DSLContext,
) {
    fun create(orderId: Long, document: Document): Document? {
        val now = OffsetDateTime.now()
        return dslContext.insertInto(DOCUMENT)
            .set(
                DOCUMENT.TYPE,
                select(DOCUMENT_TYPE.ID).from(DOCUMENT_TYPE).where(DOCUMENT_TYPE.VALUE.eq(document.type.name)),
            )
            .set(DOCUMENT.ORDER_ID, orderId)
            .set(DOCUMENT.URL, document.url)
            .set(DOCUMENT.CREATION_TIMESTAMP, now)
            .set(DOCUMENT.UPDATE_TIMESTAMP, now)
            .onConflictDoNothing()
            .returning(emptyDocumentFields)
            .fetchOne {
                mapEmptyDocument(it, document.type)
            }
    }

    fun getById(documentId: Long): Document? {
        return dslContext.select(documentFields)
            .from(DOCUMENT)
            .join(DOCUMENT_TYPE).on(DOCUMENT.TYPE.eq(DOCUMENT_TYPE.ID))
            .where(DOCUMENT.ID.eq(documentId))
            .fetchOne(DocumentDao::mapDocument)
    }

    fun getAllByOrderId(orderId: Long): List<Document> {
        return dslContext.select(documentFields)
            .from(DOCUMENT)
            .join(DOCUMENT_TYPE).on(DOCUMENT.TYPE.eq(DOCUMENT_TYPE.ID))
            .where(DOCUMENT.ORDER_ID.eq(orderId))
            .fetch(DocumentDao::mapDocument)
    }

    companion object {
        val documentFields = setOf(
            DOCUMENT.ID,
            DOCUMENT_TYPE.VALUE,
            DOCUMENT.URL,
            DOCUMENT.CREATION_TIMESTAMP,
            DOCUMENT.UPDATE_TIMESTAMP,
        )

        val emptyDocumentFields = setOf(
            DOCUMENT.ID,
            DOCUMENT.URL,
            DOCUMENT.CREATION_TIMESTAMP,
            DOCUMENT.UPDATE_TIMESTAMP,
        )

        fun mapDocument(record: Record): Document {
            return Document(
                id = record.get(DOCUMENT.ID)!!,
                type = DocumentType.valueOf(record.get(DOCUMENT_TYPE.VALUE)!!),
                url = record.get(DOCUMENT.URL)!!,
                creationTimestamp = record.get(DOCUMENT.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(DOCUMENT.UPDATE_TIMESTAMP)!!,
            )
        }

        fun mapEmptyDocument(record: Record, type: DocumentType): Document {
            return Document(
                id = record.get(DOCUMENT.ID)!!,
                type = type,
                url = record.get(DOCUMENT.URL)!!,
                creationTimestamp = record.get(DOCUMENT.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(DOCUMENT.UPDATE_TIMESTAMP)!!,
            )
        }
    }
}
