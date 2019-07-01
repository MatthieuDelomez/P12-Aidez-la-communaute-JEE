package com.app.binouz;

import com.binouz.config.SecurityConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@Import(SecurityConfig.class)
//@ComponentScan(basePackages ={ "com.app.binouz.*" })
//@EnableTransactionManagement
public class BinouzApplication extends SpringBootServletInitializer {
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BinouzApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(BinouzApplication.class, args);
	}
        
        


}
