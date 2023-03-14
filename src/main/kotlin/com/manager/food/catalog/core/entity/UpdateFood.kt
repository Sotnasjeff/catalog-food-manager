package com.manager.food.catalog.core.entity

import java.time.Instant
import java.time.LocalDateTime
import java.util.UUID

data class UpdateFood(
    val foodId: UUID,
    val quantity: Int,
    val description: String,
    val price: Double,
    val modifiedAt: LocalDateTime? = LocalDateTime.now(),
)