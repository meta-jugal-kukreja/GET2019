package com.metacube.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.assignment.service.MailSender;
import com.metacube.assignment.service.implementation.MockMailSender;
import com.metacube.assignment.service.implementation.SmtpMailSender;

/**
 * Configuration class
 * @author Jugal
 *
 */
@Configuration
public class AppConfig {
	
	@Bean
//	@Primary
	public MailSender mockMailSender()
	{
		return new MockMailSender();
	}
	
	@Bean
//	@Primary
	public MailSender smtpMailSender()
	{
		return new SmtpMailSender();
	}

}
