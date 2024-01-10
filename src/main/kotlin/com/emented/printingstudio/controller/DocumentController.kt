package com.emented.printingstudio.controller

import com.emented.printingstudio.dto.DocumentRequestDto
import com.emented.printingstudio.dto.DocumentResponseDto
import com.emented.printingstudio.dto.ResponseStatusCode
import com.emented.printingstudio.dto.StatusResponseDto
import com.emented.printingstudio.service.DocumentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/documents")
class DocumentController(
    private val documentService: DocumentService,
) {

    @GetMapping("/{documentId}")
    fun documentById(@PathVariable documentId: Long): ResponseEntity<DocumentResponseDto> {
        return documentService.documentById(documentId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/order/{orderId}")
    fun documentsByOrderId(@PathVariable orderId: Long): ResponseEntity<List<DocumentResponseDto>> {
        return ResponseEntity.ok(documentService.documentsByOrderId(orderId))
    }

    @PostMapping("/{orderId}")
    fun addDocumentToOrder(
        @PathVariable orderId: Long,
        @RequestBody documentRequestDto: DocumentRequestDto,
    ): ResponseEntity<StatusResponseDto> {
        return try {
            documentService.addDocumentToOrder(orderId, documentRequestDto)
            ResponseEntity(
                StatusResponseDto(
                    status = ResponseStatusCode.SUCCESS,
                ),
                HttpStatus.BAD_REQUEST,
            )
        } catch (exception: IllegalStateException) {
            ResponseEntity(
                StatusResponseDto(
                    status = ResponseStatusCode.ERROR,
                    message = exception.message,
                ),
                HttpStatus.BAD_REQUEST,
            )
        } catch (exception: Exception) {
            ResponseEntity(
                StatusResponseDto(
                    status = ResponseStatusCode.ERROR,
                    message = "Failed to add document!",
                ),
                HttpStatus.BAD_REQUEST,
            )
        }
    }
}
