package com.manager.food.catalog.configuration.di

import com.manager.food.catalog.configuration.properties.databaseConnectionProperties
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val propertiesConfiguration = Kodein.Module(name = "propertiesConfiguration") {
    bind() from singleton { databaseConnectionProperties(instance()) }
}