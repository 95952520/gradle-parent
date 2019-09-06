package com.xuchen.gradle.api.config;


import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author xuchen
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "baseDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.base")
    public DataSourceProperties baseDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "baseDataSource")
    public DataSource baseDataSource() {
        return baseDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "secondDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "secondDataSource")
    public DataSource secondDataSource() {
        return secondDataSourceProperties().initializeDataSourceBuilder().build();
    }

}
