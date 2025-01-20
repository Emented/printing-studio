package com.emented.printingstudio.controller

import com.emented.printingstudio.api.DocumentApiDelegate
import com.emented.printingstudio.dto.DocumentRequestDto
import com.emented.printingstudio.dto.DocumentResponseDto
import com.emented.printingstudio.dto.StatusResponseDto
import com.emented.printingstudio.dto.StatusResponseDto.Status
import com.emented.printingstudio.service.DocumentService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class DocumentApiService(
    private val documentService: DocumentService,
) : DocumentApiDelegate {

    override fun documentById(documentId: Long): ResponseEntity<DocumentResponseDto> {
        return documentService.documentById(documentId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    override fun documentsByOrderId(orderId: Long): ResponseEntity<List<DocumentResponseDto>> {
        return ResponseEntity.ok(documentService.documentsByOrderId(orderId))
    }

    override fun addDocumentToOrder(
        orderId: Long,
        documentRequestDto: DocumentRequestDto,
    ): ResponseEntity<StatusResponseDto> {
        return try {
            documentService.addDocumentToOrder(orderId, documentRequestDto)
            ResponseEntity(
                StatusResponseDto(
                    status = Status.SUCCESS,
                ),
                HttpStatus.BAD_REQUEST,
            )
        } catch (exception: IllegalStateException) {
            ResponseEntity(
                StatusResponseDto(
                    status = Status.ERROR,
                    message = exception.message,
                ),
                HttpStatus.BAD_REQUEST,
            )
        } catch (e: Exception) {
            log.error("Error during adding document", e)
            ResponseEntity(
                StatusResponseDto(
                    status = Status.ERROR,
                    message = "Failed to add document!",
                ),
                HttpStatus.BAD_REQUEST,
            )
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(DocumentApiService::class.java)
    }
}
