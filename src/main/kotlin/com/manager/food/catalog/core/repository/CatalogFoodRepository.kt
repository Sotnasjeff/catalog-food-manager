package com.manager.food.catalog.core.repository

import com.manager.food.catalog.core.entity.CreateFood
import com.manager.food.catalog.core.entity.Food
import com.manager.food.catalog.core.entity.UpdateFood
import java.util.UUID

interface CatalogFoodRepository {
    suspend fun createFood(createFood: CreateFood)
    suspend fun getFoodById(foodId: UUID): Food?
    suspend fun getAllFood(): List<Food>
    suspend fun updateFood(updateFood: UpdateFood)
}