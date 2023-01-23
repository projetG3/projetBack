package com.gromed.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DbConnection {

    @Bean
    public DataSource myDataSource(//
            @Value("${spring.datasource.url}") String url, //
            @Value("${spring.datasource.username}") String user, //
            @Value("${spring.datasource.password}") String password//
    ) {
        System.out.println("--- my datasource");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);

        return new HikariDataSource(config);
    }

}