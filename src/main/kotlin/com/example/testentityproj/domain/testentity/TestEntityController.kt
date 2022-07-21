package com.example.testentityproj.domain.testentity

import com.example.testentityproj.domain.dictionaryvalue.DictionaryValueRepository
import com.example.testentityproj.domain.document.DocumentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController("/test-entity")
class TestEntityController(
    private val testEntityService: TestEntityService,
    private val testEntityRepository: TestEntityRepository
) {

    @GetMapping("/{testEntityId}")
    fun getTestEntityById(
        @PathVariable
        testEntityId: UUID
    ): TestEntityDto {
        return testEntityRepository.findByIdOrNull(testEntityId)?.toDto() ?:
            throw Exception("There is no TestEntity with id $testEntityId")
    }

    @PostMapping
    fun addTestEntity(
        @RequestBody request: TestEntityRequest
    ): TestEntityDto {
        return testEntityService.save(request)
    }

    @PatchMapping("/{testEntityId}")
    fun editTestEntity(
        @PathVariable testEntityId: UUID,
        @RequestBody request: TestEntityRequest
    ): TestEntityDto {
        return testEntityService.edit(testEntityId, request)
    }

    @DeleteMapping("/{testEntityId}")
    fun deleteTestEntity(
        @PathVariable testEntityId: UUID
    ) {
        testEntityRepository.delete(testEntityRepository.findById(testEntityId).get())
    }
}