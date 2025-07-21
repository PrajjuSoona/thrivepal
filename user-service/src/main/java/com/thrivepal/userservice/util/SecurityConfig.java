package com.thrivepal.userservice.util;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable()) // Disable CSRF for stateless REST APIs
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(
								"/v3/api-docs*/**",
								"/swagger-ui/**",
								"/swagger-ui.html",
								"/api/auth/register",
								"/api/auth/login"
						).permitAll()
					.anyRequest().authenticated()
			)
			.httpBasic(httpBasic -> {}); // Enable basic auth

		return http.build();
	}

}

