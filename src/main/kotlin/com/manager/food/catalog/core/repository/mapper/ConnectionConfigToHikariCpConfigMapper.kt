package com.manager.food.catalog.core.repository.mapper

import com.manager.food.catalog.configuration.properties.ConnectionConfig
import com.zaxxer.hikari.HikariConfig

class ConnectionConfigToHikariCpConfigMapper {
    companion object {
        fun map(connectionConfig: ConnectionConfig): HikariConfig {
            val hikariConfig = HikariConfig()
            hikariConfig.jdbcUrl = connectionConfig.connectionString
            hikariConfig.username = connectionConfig.username
            hikariConfig.password = connectionConfig.password
            hikariConfig.connectionTimeout = connectionConfig.connectionTimeoutMs.toLong()
            hikariConfig.addDataSourceProperty("cachePrepStmts", connectionConfig.cachePrepStmts)
            hikariConfig.addDataSourceProperty("prepStmtCacheSize", connectionConfig.prepStmtCacheSize)
            hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", connectionConfig.prepStmtCacheSqlLimit)
            return hikariConfig
        }
    }
}