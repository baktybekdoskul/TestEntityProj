package com.example.testentityproj.domain.dictionaryvalue

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface DictionaryValueRepository: JpaRepository<DictionaryValueEntity, UUID>