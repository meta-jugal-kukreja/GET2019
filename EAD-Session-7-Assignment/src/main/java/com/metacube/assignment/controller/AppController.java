package com.metacube.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.assignment.service.MailSender;

/**
 * Controller class
 * @author Jugal
 *
 */
@RestController
public class AppController {
	
	MailSender mail;
	
	/*
	 * Following methods are for @Primary annotation  with @Component Annotation
	 */
//	@Autowired
//	public AppController(MailSender mail) {
//		this.mail = mail;
//	}

//	@Autowired
//	public void setMail(MailSender mail) {
//		this.mail = mail;
//	}
	
	/*
	 * Following method is for dependency injection by name with @Component Annotation
	 */
//	@Autowired
//	public AppController(MailSender mockMailSender) {
//		this.mail = mockMailSender;
//	}
//	@Autowired
//	public AppController(MailSender smtpMailSender) {
//		this.mail = smtpMailSender;
//	}
	
	/*
	 * Following method is for bean qualifiers with @Component Annotation
	 */
//	@Autowired
//	public AppController(@Qualifier("mockMailSender") MailSender mail) {
//		this.mail = mail;
//	}
//	@Autowired
//	public AppController(@Qualifier("smtpMailSender") MailSender mail) {
//		this.mail = mail;
//	}

	/*
	 * Method for configuration file using @Primary annotation
	 */
//	@Autowired
//	public AppController(MailSender mail) {
//		this.mail = mail;
//	}
	
	/*
	 * Method for configuration file using dependency injection by name
	 */
//	@Autowired
//	public AppController(MailSender mockMailSender) {
//		this.mail = mockMailSender;
//	}
//	@Autowired
//	public AppController(MailSender smtpMailSender) {
//		this.mail = smtpMailSender;
//	}
	
	/*
	 * Following method is for dependency injection by name with configuration file
	 */
//	@Autowired
//	public AppController(MailSender mockMailSender) {
//		this.mail = mockMailSender;
//	}
//	@Autowired
//	public AppController(MailSender smtpMailSender) {
//		this.mail = smtpMailSender;
//	}

	/**
	 * Method to print the text
	 * @return {String}
	 */
	@RequestMapping("/sendmail")
	public String helloWorld() {
		return mail.sendMail();
	}

}
