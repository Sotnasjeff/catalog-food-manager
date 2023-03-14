package com.manager.food.catalog.dataprovider.database.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.manager.food.catalog.core.entity.Food
import java.sql.ResultSet
import java.sql.Timestamp
import java.util.UUID

class FoodEntityMapper {
    companion object {
        fun map(result: ResultSet, mapper: ObjectMapper): Food {
            return Food(
                id = UUID.fromString(result.getString("food_id")),
                name = result.getString("name"),
                quantity = result.getString("quantity").toInt(),
                price = result.getString("price").toDouble(),
                description = result.getString("description") ?: "",
                createdAt = (result.getObject("created_at") as Timestamp).toLocalDateTime()
            )
        }
    }
}