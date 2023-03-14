package com.manager.food.catalog.configuration.properties

import com.manager.food.catalog.configuration.properties.ApplicationConfigExtension.getString
import io.ktor.server.config.ApplicationConfig

fun databaseConnectionProperties(config: ApplicationConfig): DatabaseConnectionProperties {
    return DatabaseConnectionProperties(
        defaultConnection = ConnectionConfig(
            connectionString = config.getString("jdbc.dataSources.default.connectionString"),
            username = config.getString("jdbc.dataSources.default.username"),
            password = config.getString("jdbc.dataSources.default.password"),
            useSsl = config.getString("jdbc.dataSources.default.useSsl"),
            cachePrepStmts = config.getString("jdbc.dataSources.default.cachePrepStmts"),
            prepStmtCacheSize = config.getString("jdbc.dataSources.default.prepStmtCacheSize"),
            prepStmtCacheSqlLimit = config.getString("jdbc.dataSources.default.prepStmtCacheSqlLimit"),
            connectionTimeoutMs = config.getString("jdbc.dataSources.default.connectionTimeoutMs"),
        ),
        readOnlyConnection = ConnectionConfig(
            connectionString = config.getString("jdbc.dataSources.readOnly.connectionString"),
            username = config.getString("jdbc.dataSources.readOnly.username"),
            password = config.getString("jdbc.dataSources.readOnly.password"),
            useSsl = config.getString("jdbc.dataSources.readOnly.useSsl"),
            cachePrepStmts = config.getString("jdbc.dataSources.readOnly.cachePrepStmts"),
            prepStmtCacheSize = config.getString("jdbc.dataSources.readOnly.prepStmtCacheSize"),
            prepStmtCacheSqlLimit = config.getString("jdbc.dataSources.readOnly.prepStmtCacheSqlLimit"),
            connectionTimeoutMs = config.getString("jdbc.dataSources.readOnly.connectionTimeoutMs"),
        )
    )
}

data class DatabaseConnectionProperties(
    var defaultConnection: ConnectionConfig,
    var readOnlyConnection: ConnectionConfig,
)

data class ConnectionConfig(
    var connectionString: String,
    var username: String,
    var password: String,
    var useSsl: String,
    var cachePrepStmts: String,
    var prepStmtCacheSize: String,
    var prepStmtCacheSqlLimit: String,
    var connectionTimeoutMs: String
)