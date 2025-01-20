package com.emented.printingstudio.extensions

import com.emented.printingstudio.dto.DocumentResponseDto
import com.emented.printingstudio.dto.DocumentResponseDto.Type
import com.emented.printingstudio.model.Document

fun Document.toResponse(): DocumentResponseDto {
    return DocumentResponseDto(
        id = this.id!!,
        type = Type.valueOf(this.type.name),
        url = this.url,
    )
}
