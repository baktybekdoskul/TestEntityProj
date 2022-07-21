package com.example.testentityproj.domain.document

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "document")
data class DocumentEntity (
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID = UUID.randomUUID(),
    val date: LocalDate? = null
)

fun DocumentEntity.toDto(): DocumentDto {
    return DocumentDto(id = this.id, date = this.date)
}
