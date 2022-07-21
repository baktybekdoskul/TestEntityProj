package com.example.testentityproj.domain.test

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Test(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID = UUID.randomUUID(),
    val name: String? = null
)

fun Test.toDto(): TestDto {
    return TestDto(id = this.id, name = this.name)
}