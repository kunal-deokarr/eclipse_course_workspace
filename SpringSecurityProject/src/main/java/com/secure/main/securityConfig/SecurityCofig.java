package com.secure.main.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityCofig {
	
	/* When we use spring security dependency to achieve security for our application, the dependency follows
	 * a default security filter chain in which we get some default configuration regarding security for our 
	 * application, like that username and password login form when we start the application running, that token, 
	 * header etc. But in order to customize that configuration we are configuring the security in this configuration
	 * class, by annotating the class with @EnableWebSecurity we tells spring that do not use custom security 
	 * configuration, use my custom configuration configured in this config class.
	*/

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		return httpSecurity.build(); // with only this line we have disabled all the default security
		
	}
	
}
