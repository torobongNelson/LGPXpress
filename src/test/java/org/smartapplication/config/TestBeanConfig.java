package org.smartapplication.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@TestConfiguration
public class TestBeanConfig {

    @Bean
    public Properties properties(){
        return new Properties();
    }
}
