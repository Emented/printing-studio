package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.DocumentResponseDto
import com.emented.printingstudio.model.Document

fun Document.toResponse(): DocumentResponseDto {
    return DocumentResponseDto(
        id = this.id!!,
        type = this.type,
        url = this.url,
    )
}
