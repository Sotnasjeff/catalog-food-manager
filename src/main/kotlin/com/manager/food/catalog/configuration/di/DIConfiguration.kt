package com.manager.food.catalog.configuration.di

import com.manager.food.catalog.configuration.json.configureObjectMapper
import com.typesafe.config.ConfigFactory
import io.ktor.server.config.HoconApplicationConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

@ExperimentalCoroutinesApi
val configurationModule = Kodein.Module("configuration"){
    bind<HoconApplicationConfig>() with singleton { HoconApplicationConfig(ConfigFactory.load()) }
    bind() from instance(configureObjectMapper())
    import(metricsConfiguration)

}