package com.example.testentityproj.domain.testentity

import com.example.testentityproj.domain.dictionaryvalue.DictionaryValueRepository
import com.example.testentityproj.domain.document.DocumentRepository
import com.example.testentityproj.domain.test.TestRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class TestEntityService(
    private val testRepository: TestRepository,
    private val testEntityRepository: TestEntityRepository,
    private val documentRepository: DocumentRepository,
    private val dictionaryValueRepository: DictionaryValueRepository,
    ) {
    fun save(request: TestEntityRequest): TestEntityDto {
        val documentEntity = documentRepository.findByIdOrNull(request.documentId) ?:
            throw Exception("There is no Document with id ${request.documentId}")
        val dictionaryValue = dictionaryValueRepository.findByIdOrNull(request.dictionaryValueId) ?:
            throw Exception("There is no DictionaryValue with id ${request.dictionaryValueId}")
        val test = testRepository.findByIdOrNull(request.testId) ?:
            throw Exception("There is no Test with id ${request.testId}")
        return testEntityRepository.save(TestEntity(
            documentEntity = documentEntity,
            dictionaryValue = dictionaryValue,
            test = test
        )).toDto()
    }

    fun edit(testEntityId: UUID, request: TestEntityRequest): TestEntityDto {
        val testEntity = testEntityRepository.findByIdOrNull(testEntityId) ?:
            throw Exception("There is no TestEntity with id ${testEntityId}")
        val documentEntity = documentRepository.findByIdOrNull(request.documentId) ?:
            throw Exception("There is no Document with id ${request.documentId}")
        val dictionaryValue = dictionaryValueRepository.findByIdOrNull(request.dictionaryValueId) ?:
            throw Exception("There is no DictionaryValue with id ${request.dictionaryValueId}")
        val test = testRepository.findByIdOrNull(request.testId) ?:
            throw Exception("There is no Test with id ${request.testId}")
        testEntity.documentEntity = documentEntity
        testEntity.dictionaryValue = dictionaryValue
        testEntity.test = test
        return testEntity.toDto()
    }


}
