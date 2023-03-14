package com.manager.food.catalog.configuration.datasource

import com.manager.food.catalog.configuration.properties.DatabaseConnectionProperties
import com.manager.food.catalog.core.repository.mapper.ConnectionConfigToHikariCpConfigMapper
import com.zaxxer.hikari.HikariDataSource
import java.sql.Connection

class HikariCpDataSource(dcp: DatabaseConnectionProperties) : DataSourceInterface {
    private var dataSource: HikariDataSource? = null
    private var dataSourceReadOnly: HikariDataSource? = null

    init {
        dataSource = HikariDataSource(ConnectionConfigToHikariCpConfigMapper.map(dcp.defaultConnection))
        dataSourceReadOnly = HikariDataSource(ConnectionConfigToHikariCpConfigMapper.map(dcp.readOnlyConnection))
    }

    override fun getReadOnlyConnection(): Connection {
        return dataSourceReadOnly!!.connection
    }

    override fun getConnection(): Connection {
        return dataSource!!.connection
    }

    override fun close() {
        dataSource?.close()
        dataSourceReadOnly?.close()
    }

}