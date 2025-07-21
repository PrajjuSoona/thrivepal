package com.thrivepal.healthdata.util;

import com.thrivepal.healthdata.util.JwtAuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<JwtAuthFilter> jwtFilter(JwtAuthFilter filter) {
		FilterRegistrationBean<JwtAuthFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(filter);
		registrationBean.addUrlPatterns("/api/health-data/*");
		return registrationBean;
	}
}
