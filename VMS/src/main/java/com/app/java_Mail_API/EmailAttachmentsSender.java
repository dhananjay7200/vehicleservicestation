/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package com.app.java_Mail_API;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * https://www.codejava.net/java-ee/javamail/send-e-mail-with-attachment-in-java
 */
public class EmailAttachmentsSender {

	/**
	 * i) Send n no. of Attachments
	 * 
	 * ii) Format set for TC count
	 * 
	 * iii) Send mail to n no. of Users
	 * 
	 */
	@Autowired
	private EmailConfig econfig;
	
	public static void sendEmailWithAttachments(String[] toAddress)
			throws AddressException, MessagingException {
		// sets SMTP server properties

		Properties properties = new Properties();
		properties.put("mail.smtp.host", EmailConfig.SERVER);
		properties.put("mail.smtp.port", EmailConfig.PORT);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", EmailConfig.FROM);
		properties.put("mail.password", EmailConfig.PASSWORD);

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EmailConfig.FROM, EmailConfig.PASSWORD);
			}
		};
		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(EmailConfig.FROM));

		InternetAddress[] addressTo = new InternetAddress[toAddress.length];
		for (int i = 0; i < toAddress.length; i++)
			addressTo[i] = new InternetAddress(toAddress[i]);
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		/*
		 * InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		 * msg.setRecipients(Message.RecipientType.TO, toAddresses);
		 */ msg.setSubject("This is your Billing Report");//changes my me
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		//messageBodyPart.setContent(message, "text/html");
		messageBodyPart.setContent("We serviced Your Vehicle Kindly collect your vehicle", "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
//		if (attachFiles != null && attachFiles.length > 0) {
//			for (String filePath : attachFiles) {
//				MimeBodyPart attachPart = new MimeBodyPart();
//
//				try {
//					attachPart.attachFile(filePath);
//				} catch (IOException ex) {
//					ex.printStackTrace();
//				}
//
//				multipart.addBodyPart(attachPart);
//			}
//		}

		// sets the multi-part as e-mail's content
		msg.setContent(multipart);

		// sends the e-mail
		Transport.send(msg);

	}

}
