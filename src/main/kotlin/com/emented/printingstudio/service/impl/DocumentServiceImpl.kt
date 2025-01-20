package com.emented.printingstudio.service.impl

import com.emented.printingstudio.dao.DocumentDao
import com.emented.printingstudio.dto.DocumentRequestDto
import com.emented.printingstudio.dto.DocumentResponseDto
import com.emented.printingstudio.extensions.toResponse
import com.emented.printingstudio.model.Document
import com.emented.printingstudio.model.enums.DocumentType
import com.emented.printingstudio.service.DocumentService
import org.springframework.stereotype.Service

@Service
class DocumentServiceImpl(
    private val documentDao: DocumentDao,
) : DocumentService {
    override fun documentById(documentId: Long): DocumentResponseDto? {
        val document = documentDao.getById(documentId)

        return document?.toResponse()
    }

    override fun documentsByOrderId(orderId: Long): List<DocumentResponseDto> {
        val documents = documentDao.getAllByOrderId(orderId)

        return documents.map(Document::toResponse)
    }

    override fun addDocumentToOrder(orderId: Long, documentRequestDto: DocumentRequestDto) {
        documentDao.create(orderId, documentRequestDto.toDocumentModel())
            ?: throw IllegalStateException("Unable to create document!")
    }
}

private fun DocumentRequestDto.toDocumentModel(): Document {
    return Document(
        type = DocumentType.valueOf(this.type.name),
        url = this.url,
    )
}
