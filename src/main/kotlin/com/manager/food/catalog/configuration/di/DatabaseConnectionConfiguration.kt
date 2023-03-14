package com.manager.food.catalog.configuration.di

import com.manager.food.catalog.configuration.datasource.DataSourceInterface
import com.manager.food.catalog.configuration.datasource.HikariCpDataSource
import com.manager.food.catalog.configuration.properties.DatabaseConnectionProperties
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val databaseConnectionConfiguration = Kodein.Module("databaseConnectionConfiguration") {
    bind() from singleton { buildDataSource(instance()) }
}

fun buildDataSource(databaseConnectionProperties: DatabaseConnectionProperties): DataSourceInterface {
    return HikariCpDataSource(databaseConnectionProperties)
}
