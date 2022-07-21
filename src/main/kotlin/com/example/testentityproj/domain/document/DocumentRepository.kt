package com.example.testentityproj.domain.document

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface DocumentRepository: JpaRepository<DocumentEntity, UUID>