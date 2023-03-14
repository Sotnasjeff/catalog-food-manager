package com.manager.food.catalog.web.route.v1

import com.manager.food.catalog.core.entity.CreateFood
import com.manager.food.catalog.core.entity.UpdateFood
import com.manager.food.catalog.core.service.CatalogFoodService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.locations.Location
import io.ktor.server.locations.get
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import java.util.UUID
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.kodein.di.Kodein
import org.kodein.di.direct
import org.kodein.di.generic.instance

@ExperimentalCoroutinesApi
fun Routing.catalogFoodRoutes(kodein: Kodein) {
    val catalogFoodService: CatalogFoodService = kodein.direct.instance()

    post("/v1/food/register") {
        try {
            val payload: CreateFood = call.receive()

            catalogFoodService.createFood(
                payload
            )

            call.respond(HttpStatusCode.Accepted)
        } catch (e: Exception) {
            call.respond(e)
        }

    }

    get("/v1/food/catalog") {
        try {
            call.respond(
                catalogFoodService.getAllFood()
            )
        } catch (e: Exception) {
            call.respond(e)
        }
    }

    put("/v1/food/update") {
        try {
            val payload: UpdateFood = call.receive()
            call.respond(
                catalogFoodService.updateFood(
                    payload
                )
            )
        } catch (e: Exception) {
            call.respond(e)
        }
    }

    get<GetFoodByIdRoute> {
        try {
            call.respond(
                catalogFoodService.getFoodById(
                    UUID.fromString(it.foodId)
                )
            )
        } catch (e: Exception) {
            call.respond(e)
        }
    }
}

@Location("/v1/food/catalog/{foodId}")
data class GetFoodByIdRoute(
    val foodId: String
)