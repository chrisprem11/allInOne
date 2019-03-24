package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailClientService {

	private JavaMailSender mailSender;
	private MailContentBuilder mailContentBuilder;
	
	@Autowired
	private Environment environment;

	@Autowired
	public MailClientService(JavaMailSender mailSender, MailContentBuilder mailContentBuilder) {
		this.mailSender = mailSender;
		this.mailContentBuilder = mailContentBuilder;
	}

	public void prepareAndSend(String recipient, String message) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//			messageHelper.setFrom(environment.getRequiredProperty("spring.mail.username"));
			messageHelper.setTo(recipient);
			messageHelper.setSubject("Sample mail subject");
			String content = mailContentBuilder.build(message);
			messageHelper.setText(content, true);
		};
		try {
			mailSender.send(messagePreparator);
			System.out.println("Mail Sent");
		} catch (MailException e) {
			System.out.println("Email Error"+ e.getMessage());
		}
	}
}
