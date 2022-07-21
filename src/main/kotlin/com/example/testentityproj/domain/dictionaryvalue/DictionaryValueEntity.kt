package com.example.testentityproj.domain.dictionaryvalue

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "dictionary_value")
data class DictionaryValueEntity (
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID = UUID.randomUUID(),
    val name: String? = null
)

fun DictionaryValueEntity.toDto(): DictionaryValueDto {
    return DictionaryValueDto(id = this.id, name = this.name)
}