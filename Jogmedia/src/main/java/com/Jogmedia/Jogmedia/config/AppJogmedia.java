package com.Jogmedia.Jogmedia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({"com.Jogmedia.Jogmedia.*"})
public class AppJogmedia {
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("password");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/jogmedia_db");
        return driverManagerDataSource;
    }
}
