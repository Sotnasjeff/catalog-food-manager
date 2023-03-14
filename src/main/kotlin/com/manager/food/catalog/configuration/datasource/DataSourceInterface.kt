package com.manager.food.catalog.configuration.datasource

import java.sql.Connection

interface DataSourceInterface {
    fun getReadOnlyConnection(): Connection
    fun getConnection(): Connection
    fun close()
}