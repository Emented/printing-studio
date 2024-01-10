package com.emented.printingstudio.service

import com.emented.printingstudio.dto.DocumentRequestDto
import com.emented.printingstudio.dto.DocumentResponseDto

interface DocumentService {
    fun documentById(documentId: Long): DocumentResponseDto?
    fun documentsByOrderId(orderId: Long): List<DocumentResponseDto>
    fun addDocumentToOrder(orderId: Long, documentRequestDto: DocumentRequestDto)
}
