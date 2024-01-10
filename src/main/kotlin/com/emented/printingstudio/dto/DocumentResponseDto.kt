package com.emented.printingstudio.dto

import com.emented.printingstudio.model.enums.DocumentType

data class DocumentResponseDto(
    var id: Long,
    var type: DocumentType,
    var url: String,
)
