package com.manager.food.catalog.core.repository

import com.fasterxml.jackson.databind.ObjectMapper
import com.manager.food.catalog.configuration.datasource.DataSourceInterface
import org.slf4j.LoggerFactory

abstract class BaseRepository(
    protected val dataSource: DataSourceInterface,
    protected val objectMapper: ObjectMapper
) {
    protected val log = LoggerFactory.getLogger(this::class.java)
}