package com.manager.food.catalog.core.service

import com.manager.food.catalog.core.entity.CreateFood
import com.manager.food.catalog.core.entity.Food
import com.manager.food.catalog.core.entity.UpdateFood
import com.manager.food.catalog.core.exception.FoodNotFoundException
import com.manager.food.catalog.core.repository.CatalogFoodRepository
import com.manager.food.catalog.log.LogContextHelper.getLogContext
import java.util.UUID
import org.slf4j.LoggerFactory

class CatalogFoodService(private val catalogFoodRepository: CatalogFoodRepository) {
    suspend fun createFood(createFood: CreateFood) {
        catalogFoodRepository.createFood(createFood)
        log.info("Created food", getLogContext())
    }

    suspend fun getFoodById(foodId: UUID): Food {
        val getFood = catalogFoodRepository.getFoodById(foodId)
        return getFood ?: throw FoodNotFoundException()
    }

    suspend fun getAllFood(): List<Food> {
        return catalogFoodRepository.getAllFood()
    }

    suspend fun updateFood(updateFood: UpdateFood) {
        catalogFoodRepository.updateFood(updateFood)
        log.info("Updated food", getLogContext())
    }

    private val log = LoggerFactory.getLogger("com.manager.food.catalog.core.service.CatalogFoodService")
}