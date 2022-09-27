package com.vssm.emailsender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.vssm.entity.BookingTable;
@Component
public class EmailCustomer {


	private JavaMailSender mailsender;
	@Autowired 
	public  EmailCustomer( JavaMailSender mailsender)
	{
		this.mailsender=mailsender;

	}
	public  EmailCustomer()
	{

	}
	//after booking email is sent to counsumer email id
	public void sendMail(BookingTable obj)
	{

			SimpleMailMessage message=new SimpleMailMessage();
			String ReciverEmail=obj.getCustomer().getEmail();
			System.out.println("reciver email"+ReciverEmail );
			 message.setSubject("Booking Confirmation");
			 message.setTo(ReciverEmail);
			 String content="Dear  "+obj.getCustomer().getFirstName()+" "+ obj.getCustomer().getLastName()+"\n\n";
			  content+="\n You have successfully booked a servicing slot for your vehicle at "+" "+ obj.getServiceCenterref().getName();
			  content+="\nResigtration Details:"
			  		+ "\n Vehicle No:  "+obj.getvehicleRegNo()+""
			  				+ "\n Total Cost: " +obj.gettotalCost()+""
			  						+ "\n Booked Date "+ obj.getBookingDate();	
			  message.setText(content);
			  System.out.println("get from "+message.getFrom()+" "+ message.getTo()+" "+ message.getText());
			 mailsender.send(message);

		}
	}