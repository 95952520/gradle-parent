package com.xuchen.gradle.api.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author xuchen
 */
@Configuration
@MapperScan(basePackages = {"com.xuchen.gradle.core.base"}, annotationClass = Mapper.class, sqlSessionFactoryRef = "baseSessionFactory")
public class BaseMybatisConfig {
    @Bean(name = "baseSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("baseDataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource mybatisConfigXml = resolver.getResource("classpath:mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
        Resource[] mapperXmls = resolver.getResources("classpath*:mapper/**/*.xml");
        sqlSessionFactoryBean.setMapperLocations(mapperXmls);
        return sqlSessionFactoryBean;
    }

    @Bean(name = "baseTransactionManager")
    public DataSourceTransactionManager baseTransactionManager(@Qualifier("baseDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
