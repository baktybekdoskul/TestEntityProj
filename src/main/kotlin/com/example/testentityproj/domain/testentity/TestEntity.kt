package com.example.testentityproj.domain.testentity

import com.example.testentityproj.domain.dictionaryvalue.DictionaryValueEntity
import com.example.testentityproj.domain.dictionaryvalue.toDto
import com.example.testentityproj.domain.document.DocumentEntity
import com.example.testentityproj.domain.document.toDto
import com.example.testentityproj.domain.test.Test
import com.example.testentityproj.domain.test.toDto
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "test_entity")
data class TestEntity (
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID = UUID.randomUUID(),
    @OneToOne
    var documentEntity: DocumentEntity?,
    @OneToOne
    var dictionaryValue: DictionaryValueEntity?,
    @OneToOne
    var test: Test?
)

fun TestEntity.toDto(): TestEntityDto {
    return TestEntityDto(
        id = this.id,
        documentDto = this.documentEntity?.toDto(),
        dictionaryValueDto = this.dictionaryValue?.toDto(),
        testDto = this.test?.toDto()
    )
}