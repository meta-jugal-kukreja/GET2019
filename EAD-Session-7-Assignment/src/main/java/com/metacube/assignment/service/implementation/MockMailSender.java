package com.metacube.assignment.service.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.assignment.service.MailSender;

//@Component
//@Primary
public class MockMailSender implements MailSender {

	@Override
	public String sendMail() {
		return "Mock Mail";
	}

}
