package com.manager.food.catalog.core.entity

import java.util.UUID

data class CreateFood(
    val clientId: UUID?,
    val food: Food
)