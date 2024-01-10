package com.emented.printingstudio.model

import com.emented.printingstudio.model.enums.DocumentType
import java.time.OffsetDateTime

data class Document(
    var id: Long? = null,
    var type: DocumentType,
    var url: String,
    var creationTimestamp: OffsetDateTime? = null,
    var updateTimestamp: OffsetDateTime? = null,
)
