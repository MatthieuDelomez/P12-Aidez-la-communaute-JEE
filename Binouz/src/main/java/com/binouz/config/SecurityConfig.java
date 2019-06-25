
package com.binouz.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    
   
    
    
                      @Autowired
                      UserDetailsService userDetailsService;
                      
                      @Autowired
                      public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
                          auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());;
                      }
    
                      @Autowired
                      DataSource dataSource;
    


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            
                            auth.jdbcAuthentication().dataSource(dataSource)
                                    .usersByUsernameQuery("SELECT username, password, enabled FROM app_user WHERE username=? ")
                                    .authoritiesByUsernameQuery("SELECT username, role FROM user_roles WHERE username=?").passwordEncoder(passwordencoder());
           
                             
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
            
            /*
            http.authorizeRequests()
                    .antMatchers("/index").access("hasRole('ROLE_ADMIN')")
                    .anyRequest().permitAll()
                    .and()
                    
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username").passwordParameter("password")
                    
                    .and()
                    
                    .logout().logoutSuccessUrl("/login?logout")
                    .and()
                    .exceptionHandling().accessDeniedPage("/403")
                    .and()
                    .csrf().disable();
            
            /*
            http.authorizeRequests()
                    .antMatchers("/", "index")
                    .permitAll()
                    .antMatchers("/admin")
                    .hasRole("ADMIN")
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();
            
            http.exceptionHandling().accessDeniedPage("/403");
            
            */
            
            http.authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll();

            
            /*
	    http.authorizeRequests().antMatchers("/admin/**")
		.access("hasRole('ROLE_ADMIN')").and().formLogin()
		.loginPage("/login").failureUrl("/login?error")
		.usernameParameter("username")
		.passwordParameter("password")
		.and().logout().logoutSuccessUrl("/login?logout")
		.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/403");

*/
	}
        
         @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }
	

    
    
    
}
