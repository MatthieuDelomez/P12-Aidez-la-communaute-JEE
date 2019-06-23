
package com.binouz.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                              auth.inMemoryAuthentication().withUser("admin").password(("123")).roles("ADMIN");
                              auth.inMemoryAuthentication().withUser("user").password(("123")).roles("USER");
                             
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
            
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
	

    
    
    
}
