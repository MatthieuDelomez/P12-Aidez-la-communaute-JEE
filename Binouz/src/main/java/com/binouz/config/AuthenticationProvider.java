
package com.binouz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;



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
    
    /*
    @Bean(name = "userDetailsService")
    public UserDetailsService userDetailsService() {
        
        JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
        jdbcImpl.setDataSource(dataSource());
        jdbcImpl.setUsersByUsernameQuery("SELECT username, password, enabled FROM app_user WHERE username=? ");
        jdbcImpl.setAuthoritiesByUsernameQuery("SELECT username, role FROM user_roles WHERE username=?");
        
        return jdbcImpl;
    }*/
    
}
