package com.javarush.jira.common.internal.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Slf4j
@Configuration
public class DotenvConfig {
    @PostConstruct
    public void loadEnv() {
        log.info("Loading .env file...");
        Dotenv dotenv = Dotenv.configure()
                .directory("D:/IdeaProjects/project-final")
                .ignoreIfMissing()
                .load();
        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
            log.info("Loaded environment variable: {}={}", entry.getKey(), entry.getValue());
        });
    }
}
