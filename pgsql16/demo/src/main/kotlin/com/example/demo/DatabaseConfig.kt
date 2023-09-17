package com.example.demo

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.support.TransactionSynchronizationManager
import javax.sql.DataSource

@Configuration
class DatabaseConfig {

//    companion object {
//        private const val primaryDataSourcePropertiesName = "primaryDataSourceProperties"
//        private const val replicationDataSourcePropertiesName = "replicationDataSourceProperties"
//        private const val primaryDataSourceName = "primaryDataSource"
//        private const val replicationDataSourceName = "replicationDataSource"
//        private const val routerDataSourceName = "routingDataSource"
//        private const val mainDataSourceName = "dataSource"
//    }
//
//    enum class DataSourceType {
//        PRIMARY, REPLICATION
//    }
//
//    /**
//     * TransactionのreadOnlyをもとにDataSourceをルーティングするためのカスタムルーティングクラス
//     */
//    class CustomRoutingDataSource : AbstractRoutingDataSource() {
//        override fun determineCurrentLookupKey(): Any {
//            return if (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) {
//                DataSourceType.REPLICATION
//            } else {
//                DataSourceType.PRIMARY
//            }
//        }
//    }
//
//    /**
//     * Primary用DataSourceのプロパティを作成
//     * @return Primary用DataSourceのプロパティ
//     */
//    @Bean(name = [primaryDataSourcePropertiesName])
//    @Primary
//    fun primaryDataSourceProperties(): DataSourceProperties {
//        val dataSourceProperties = DataSourceProperties()
//        dataSourceProperties.driverClassName = "org.postgresql.Driver"
//        dataSourceProperties.username = "postgres"
//        dataSourceProperties.password = "password"
//        dataSourceProperties.url = "jdbc:postgresql://localhost:15432/postgres"
//        return dataSourceProperties
//    }
//
//    /**
//     * Replication用DataSourceのプロパティを作成
//     * @return Replication用DataSourceのプロパティ
//     */
//    @Bean(name = [replicationDataSourcePropertiesName])
//    fun replicationDataSourceProperties(): DataSourceProperties {
//        val dataSourceProperties = DataSourceProperties()
//        dataSourceProperties.driverClassName = "org.postgresql.Driver"
//        dataSourceProperties.username = "postgres"
//        dataSourceProperties.password = "password"
//        // targetServerType=preferSecondary
//        dataSourceProperties.url =
//            "jdbc:postgresql://localhost:15433,localhost:15434/postgres?loadBalanceHosts=true"
//        return dataSourceProperties
//    }
//
//    /**
//     * Primary用DBエンドポイントのDataSourceを作成
//     * @return Primary用DBエンドポイントのDataSource
//     */
//    @Bean(name = [primaryDataSourceName])
//    @Primary
//    @Suppress("MagicNumber")
//    fun primaryDataSource(@Qualifier(primaryDataSourcePropertiesName)
//                          dataSourceProperties: DataSourceProperties): DataSource {
//        val hikariDataSource: HikariDataSource =
//            dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource::class.java).build()
//        hikariDataSource.maxLifetime = 600000
//        hikariDataSource.maximumPoolSize = 10
//        hikariDataSource.isReadOnly = false
//        hikariDataSource.isAutoCommit = false
//        return hikariDataSource
//    }
//
//    /**
//     * Replication用DBエンドポイントのDataSourceを作成
//     * @return Replication用DBエンドポイントのDataSource
//     */
//    @Bean(name = [replicationDataSourceName])
//    @Suppress("MagicNumber")
//    fun replicationDataSource(@Qualifier(replicationDataSourcePropertiesName)
//                              dataSourceProperties: DataSourceProperties): DataSource {
//        val hikariDataSource: HikariDataSource =
//            dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource::class.java).build()
//        hikariDataSource.maxLifetime = 600000
//        hikariDataSource.maximumPoolSize = 20

//        return hikariDataSource
//    }
//
//    /**
//     * SQLを実行するDataSourceを、Transactionによってルーティングするための設定を作成
//     * @param primaryDataSource Primary用DBエンドポイントのDataSource
//     * @param replicationDataSource Replication用DBエンドポイントのDataSource
//     * @return SQLを実行するDataSourceを、Transactionによってルーティングするための設定
//     */
//    @Bean(name = [routerDataSourceName])
//    fun routingDataSource(
//        @Qualifier(primaryDataSourceName) primaryDataSource: DataSource,
//        @Qualifier(replicationDataSourceName) replicationDataSource: DataSource,
//    ): DataSource {
//        val routingDataSource = CustomRoutingDataSource()
//        val dataSourceMap: Map<Any, Any> = HashMap()
//        dataSourceMap[DataSourceType.PRIMARY to primaryDataSource]
//        dataSourceMap[DataSourceType.REPLICATION to replicationDataSource]
//
//        routingDataSource.setTargetDataSources(dataSourceMap)
//        routingDataSource.setDefaultTargetDataSource(primaryDataSource)
//
//        return routingDataSource
//    }
//
//    /**
//     * TransactionによってDataSourceをルーティングするDataSourceを作成
//     * @param routingDataSource SQLを実行するDataSourceを、Transactionによってルーティングするための設定
//     * @return TransactionによってDataSourceをルーティングするDataSource
//     */
//    @Bean(name = [mainDataSourceName])
//    fun dataSource(@Qualifier(routerDataSourceName) routingDataSource: DataSource): DataSource {
//        return LazyConnectionDataSourceProxy(routingDataSource)
//    }
//
//    /**
//     * トランザクションマネージャを作成
//     * @param dataSource TransactionによってDataSourceをルーティングするDataSource
//     * @return トランザクションマネージャ
//     */
//    @Bean
//    @Primary
//    fun transactionManager(@Qualifier(mainDataSourceName) dataSource: DataSource): PlatformTransactionManager {
//        return DataSourceTransactionManager(dataSource)
//    }
}
