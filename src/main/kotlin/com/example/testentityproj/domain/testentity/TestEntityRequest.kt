package com.example.testentityproj.domain.testentity

import java.util.UUID

data class TestEntityRequest (
    val documentId: UUID?,
    val dictionaryValueId: UUID?,
    val testId: UUID?
)