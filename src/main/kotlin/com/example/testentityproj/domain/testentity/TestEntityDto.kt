package com.example.testentityproj.domain.testentity

import com.example.testentityproj.domain.dictionaryvalue.DictionaryValueDto
import com.example.testentityproj.domain.document.DocumentDto
import com.example.testentityproj.domain.test.TestDto
import java.util.UUID

data class TestEntityDto (
    val id: UUID,
    val documentDto: DocumentDto?,
    val dictionaryValueDto: DictionaryValueDto?,
    val testDto: TestDto?
)
