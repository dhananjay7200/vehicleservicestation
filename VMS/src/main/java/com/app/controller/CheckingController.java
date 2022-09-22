package com.app.controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UserRepository;
import com.app.java_Mail_API.EmailAttachmentsSender;

@RestController
@CrossOrigin(origins="*")

public class CheckingController {
	
	@Autowired
	private EmailAttachmentsSender emailservice;
	
	@Autowired
	private UserRepository urepo;
	
	@PostMapping("/home/{id}")
	public String sendEmail(@PathVariable int id) throws AddressException, MessagingException {
		String[] email=urepo.getEmailId(id);
		emailservice.sendEmailWithAttachments(email);
		return "Email Sent";
		
	}
}


