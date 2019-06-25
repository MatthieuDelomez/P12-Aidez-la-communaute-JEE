
package com.binouz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;




@Configuration
public class AuthenticationProvider {
    
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/AppBin'z");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("root");
        
        return driverManagerDataSource;
    }
    
    
}
