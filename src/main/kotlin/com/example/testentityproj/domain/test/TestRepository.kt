package com.example.testentityproj.domain.test

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TestRepository: JpaRepository<Test, UUID>