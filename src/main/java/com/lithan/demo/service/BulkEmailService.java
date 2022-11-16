package com.lithan.demo.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lithan.demo.dto.BulkEmail;
import com.lithan.demo.dao.BulkEmailRepo;

@Service
public class BulkEmailService {

	@Autowired
	BulkEmailRepo bulkRepo;
	@Autowired
	private JavaMailSender emailSender;
	
	BulkEmail bulkemail = new BulkEmail();
	
	public void sentBulk(BulkEmail l) {
		System.out.println(l);
		
		bulkRepo.save(l);
	
	}
public void sendEmail(String subject, String email,String description) {
	final String from = "admin@gmail.com";

	
		System.out.println("subject = " +subject);
		System.out.println("email = " +email);
		System.out.println("description = " +description);
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(from);
		message.setTo(email);
		message.setSubject(subject);
		message.setText(description);
		emailSender.send(message);
		
}
}
