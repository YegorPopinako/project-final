package com.javarush.jira;

import com.javarush.jira.common.internal.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@EnableConfigurationProperties(AppProperties.class)
@EnableCaching
@SpringBootApplication
public class JiraRushApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiraRushApplication.class, args);
    }
}
