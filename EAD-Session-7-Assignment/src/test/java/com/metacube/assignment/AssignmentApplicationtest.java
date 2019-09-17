package com.metacube.assignment;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metacube.assignment.service.MailSender;
import com.metacube.assignment.service.implementation.MockMailSender;
import com.metacube.assignment.service.implementation.SmtpMailSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignmentApplicationtest {

	@Test
	public void testMockMail() {
		MailSender mail = new MockMailSender();
		assertEquals("Mock Mail",mail.sendMail());
	}
	
	@Test
	public void testSMTPMail() {
		MailSender mail = new SmtpMailSender();
		assertEquals("SMTP Mail",mail.sendMail());
	}

}
