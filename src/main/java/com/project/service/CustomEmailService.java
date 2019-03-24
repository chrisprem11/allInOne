package com.project.service;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mail.Mail;

@Service
public class CustomEmailService {

	private static Logger log = LoggerFactory.getLogger(CustomEmailService.class);

	@Autowired
	private EmailService emailService;

	public void sendEmail(String recipient, String subject,Map<String, Object> model) {
		Mail mail = new Mail();
//		 mail.setFrom("no-reply@memorynotfound.com");
		mail.setTo(recipient);
		mail.setSubject(subject);
		mail.setModel(model);

		log.info("About to send email...");
		try {
			emailService.sendSimpleMessage(mail);
			log.info("Email Sent...");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error Occured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
