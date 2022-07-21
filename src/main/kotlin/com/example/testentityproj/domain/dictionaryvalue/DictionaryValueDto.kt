package com.example.testentityproj.domain.dictionaryvalue

import java.util.UUID

data class DictionaryValueDto (
    val id: UUID = UUID.randomUUID(),
    val name: String?
)