package com.metacube.assignment.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.assignment.filter.ValidationFilter;

/**
 * This class represents the configuration for the Filter
 * @author Jugal
 * Dated 09/16/2019
 */
@Configuration
public class AppConfiguration {

	@Bean
	public FilterRegistrationBean<ValidationFilter> loggingFilter(){
	    FilterRegistrationBean<ValidationFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new ValidationFilter());
	    registrationBean.addUrlPatterns("/employeeLogin/*");  
	    registrationBean.addUrlPatterns("/employeeRegistration");  
	    return registrationBean;    
	}
}
