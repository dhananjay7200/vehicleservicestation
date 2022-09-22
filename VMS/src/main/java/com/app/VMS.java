package com.app;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.java_Mail_API.EmailAttachmentsSender;
import com.app.java_Mail_API.EmailConfig;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class VMS {

//	@Autowired
//	private EmailAttachmentsSender sende;
//	
	public static void main(String[] args) {
		SpringApplication.run(VMS.class, args);
	}
	
	@Bean //equivalent to <bean> tag in xml file
	public ModelMapper mapper()
	{
		System.out.println("in mapper");
		return new ModelMapper();
	}
	
	@Bean
	public EmailAttachmentsSender encoder()
	{
		return new EmailAttachmentsSender();
	}
	

	@Bean
	public EmailConfig encode()
	{
		return new EmailConfig();
	}
	
	

}
