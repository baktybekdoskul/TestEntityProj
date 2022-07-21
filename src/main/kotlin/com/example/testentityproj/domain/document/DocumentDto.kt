package com.example.testentityproj.domain.document

import java.time.LocalDate
import java.util.UUID

data class DocumentDto (
    val id: UUID,
    val date: LocalDate?
)