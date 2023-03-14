package com.manager.food.catalog.configuration.di

import com.manager.food.catalog.core.repository.CatalogFoodRepository
import com.manager.food.catalog.dataprovider.database.PgCatalogFoodRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val repositoryConfiguration = Kodein.Module(name = "repositoryConfiguration") {
    bind<CatalogFoodRepository>() with singleton { PgCatalogFoodRepository(instance(), instance()) }
}