package com.emented.printingstudio.dto

import com.emented.printingstudio.model.enums.DocumentType

data class DocumentRequestDto(
    var type: DocumentType,
    var url: String,
)
