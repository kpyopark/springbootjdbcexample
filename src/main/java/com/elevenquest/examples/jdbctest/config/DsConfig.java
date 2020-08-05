package com.elevenquest.examples.jdbctest.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DsConfig {
  @Bean(name = "customDataSource")
  @ConfigurationProperties("spring.datasource")
  public DataSource customDataSource() {
    return DataSourceBuilder.create().build();
  }  
}