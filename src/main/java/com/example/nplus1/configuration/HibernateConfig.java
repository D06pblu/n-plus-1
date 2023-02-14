package com.example.nplus1.configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
public class HibernateConfig {

//    @Bean
//    public EntityManager entityManager(LocalContainerEntityManagerFactoryBean entityManagerFactory){
//        return entityManagerFactory.;
//    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/first_db");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("PWD4admin");
        return dataSourceBuilder.build();
    }
}
