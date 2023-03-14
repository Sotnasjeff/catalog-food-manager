package com.manager.food.catalog.core.entity

import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.util.UUID

data class Food(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val quantity: Int,
    val price: Double,
    val description: String? = null,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val modifiedAt: LocalDateTime? = null
)