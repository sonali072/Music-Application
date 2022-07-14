package com.microservice.music.crud.securityConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//Authentication : set user/password details and mention the role.
	protected void configure(AuthenticationManagerBuilder authenticate) throws Exception {
		authenticate.inMemoryAuthentication()
				.withUser("Sonali").password("{noop}sonali123").roles("USER").and()
				.withUser("admin").password("{noop}admin123").roles("USER", "ADMIN");
	}
	
	//Authorization : mention which role can access which URL
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
			.antMatchers("/userLogin").hasRole("USER")
			.antMatchers("/adminLogin").hasRole("ADMIN").and()
			.csrf().disable().headers().frameOptions().disable();
	}
	
}