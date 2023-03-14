package com.manager.food.catalog.dataprovider.database

import com.fasterxml.jackson.databind.ObjectMapper
import com.manager.food.catalog.configuration.datasource.DataSourceInterface
import com.manager.food.catalog.core.entity.CreateFood
import com.manager.food.catalog.core.entity.Food
import com.manager.food.catalog.core.entity.UpdateFood
import com.manager.food.catalog.core.repository.BaseRepository
import com.manager.food.catalog.core.repository.CatalogFoodRepository
import com.manager.food.catalog.dataprovider.database.mapper.FoodEntityMapper
import com.manager.food.catalog.util.withResources
import java.util.UUID

class PgCatalogFoodRepository(
    dataSource: DataSourceInterface,
    objectMapper: ObjectMapper
) : BaseRepository(dataSource, objectMapper), CatalogFoodRepository {

    override suspend fun createFood(createFood: CreateFood) {
        withResources {
            val stmt = dataSource.getConnection().use().prepareStatement(SQL_INSERT).use()
            stmt.setObject(1, createFood.food.id)
            stmt.setString(2, createFood.food.name)
            stmt.setInt(3, createFood.food.quantity)
            stmt.setDouble(4, createFood.food.price)
            stmt.setString(5, createFood.food.description)
            stmt.setObject(6, createFood.food.createdAt)
            stmt.setObject(7, createFood.food.modifiedAt)

            stmt.executeUpdate()

        }
    }

    override suspend fun getFoodById(foodId: UUID): Food {
        withResources {
            val stmt = dataSource.getConnection().use().prepareStatement(SQL_GET_BY_ID).use()
            stmt.setObject(1, foodId)
            val result = stmt.executeQuery()
            var food = Food(name = "", price = 0.0, quantity = 0)

            while (result.next()) {
                food = FoodEntityMapper.map(result, objectMapper)
            }

            return food
        }
    }

    override suspend fun getAllFood(): List<Food> {
        withResources {
            val stmt = dataSource.getReadOnlyConnection().use().prepareStatement(SQL_GET_ALL_FOOD).use()
            val result = stmt.executeQuery()
            val list = mutableListOf<Food>()

            while (result.next()) {
                list.add(FoodEntityMapper.map(result, objectMapper))
            }

            return list.toList()
        }
    }

    override suspend fun updateFood(updateFood: UpdateFood) {
        withResources {
            val stmt = dataSource.getConnection().use().prepareStatement(SQL_UPDATE_FOOD_BY_ID).use()
            stmt.setInt(1, updateFood.quantity)
            stmt.setString(2, updateFood.description)
            stmt.setDouble(3, updateFood.price)
            stmt.setObject(4, updateFood.modifiedAt)
            stmt.setObject(5, updateFood.foodId)

            stmt.executeUpdate()
        }
    }

    companion object {
        const val SQL_INSERT = """
            INSERT INTO food (
                food_id,
                name,
                quantity,
                price,
                description,
                created_at,
                modified_at
            ) VALUES (?, ?, ?, ?, ?, ?, ?)
        """

        const val SQL_GET_BY_ID = """
            SELECT * FROM food WHERE food_id = ?
        """

        const val SQL_GET_ALL_FOOD = """
            SELECT * FROM food
        """

        const val SQL_UPDATE_FOOD_BY_ID = """
            UPDATE food 
            SET quantity = ?,
                description = ?,
                price = ?,
                modified_at = ?
            WHERE food_id = ?
        """
    }
}