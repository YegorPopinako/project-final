package com.javarush.jira.common.internal.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DataSourceConfig {
    @Bean
    @Profile("prod")
    public DataSource dataSource(@Value("${DB_USERNAME}") String username,
                                 @Value("${DB_PASSWORD}") String password) {

        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5433/jira-test")
                .username(username)
                .password(password)
                .driverClassName("org.postgresql.Driver")
                .build();
    }


    @Bean
    @Profile("test")
    public DataSource h2DataSource() {
        log.info("Using H2 DataSource for testing");
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL")
                .username("sa")
                .password("")
                .driverClassName("org.h2.Driver")
                .build();
    }
}

