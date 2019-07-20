
package com.binouz.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
                      @Autowired
                       private UserDetailsService userDetailsService;
                      
    
                      @Autowired
                      public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
                          auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());;
                      }
    
                      @Autowired
                      DataSource dataSource;
    


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                        
                            auth.userDetailsService(userDetailsService)
                                    
                                    .passwordEncoder(bCryptPasswordEncoder());
            
                            auth.jdbcAuthentication().dataSource(dataSource)
                                    .usersByUsernameQuery("SELECT username, password, enabled FROM app_user WHERE username=? ")
                                    .authoritiesByUsernameQuery("SELECT username, role FROM user_roles WHERE username=?").passwordEncoder(passwordencoder());
           
                             
	}
        
        
        @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }
    
    
    //******************************************************************************************************************************************************
    


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        
        
        http.authorizeRequests()
                    .antMatchers("/registration", "/css/**", "/js/**", "/vendor/**").permitAll();
        

                
            
            
            http
                    .authorizeRequests()
                    
                    .anyRequest()
                    .authenticated()
                    
                    
                    .and()
                    .formLogin()
                    .loginPage("/login")

                    .permitAll()
                    
                    .defaultSuccessUrl("/index")
                    .failureUrl("/403");
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }


}
    
    
    
    
    
    
    
    

    
    

