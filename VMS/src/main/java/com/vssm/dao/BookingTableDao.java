package com.vssm.dao;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.vssm.emailsender.EmailCustomer;
import com.vssm.entity.BookingTable;
import com.vssm.entity.Customer;
import com.vssm.entity.ServiceCenter;
import com.vssm.repository.BookingTableRepository;
import com.vssm.repository.CustomerRepository;
import com.vssm.repository.ServiceCenterRepository;
import com.vssm.repository.ServiceSlotInfoRepository;

@Component
public class BookingTableDao {


	@Autowired
	private ServiceSlotInfoRepository slotRepo;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private ServiceCenterRepository centerRepo;
	
	@Autowired
	private  EmailCustomer emailCustomer;
	@Autowired
	private BookingTableRepository bookingRepo;


	public BookingTableDao()
	{
		
	}
	
	@Autowired
	public BookingTableDao(BookingTableRepository bookingRepo)
	{

		this.bookingRepo = bookingRepo;
	}
	
	//to add new bookings {via booking table controller}
	public ResponseEntity<String> addBookingDetails(BookingTable bookingObject)
	{
		System.out.println(bookingObject);
		String customerEmail=bookingObject.getCustomer().getEmail();
		System.out.println(customerEmail);
		
		 Customer customer=customerRepo.findByEmail(customerEmail);
		 System.out.println(customer);	 
		 System.out.println(customer.getEmail()+"cusomer name"+customer.getFirstName());
		 bookingObject.setCustomer(customer);
		 
		 int registrtaionNumber=bookingObject.getServiceCenterref().getRegNo();
		 ServiceCenter center=centerRepo.findByRegNo(registrtaionNumber);
		 bookingObject.setServiceCenterref(center);
		 
		 System.out.println("printing the service center object "+ center.getName());
		BookingTable book = bookingRepo.save(bookingObject);
		if(book!=null)
		{
			System.out.println("objcet saved ");
			
			 String bookingDate=book.getBookingDate();
			slotRepo.upDateSlot(center, bookingDate);
			emailCustomer.sendMail(book);
			return new  ResponseEntity<String>("okk",HttpStatus.OK);
		}
		int bookingId = book.getbookingId();
		return new ResponseEntity<String>("okk",HttpStatus.BAD_REQUEST);
	}
	
	//to get todays bookings {via booking table controller}
	public List<BookingTable> getTodaysBooking(String email ,String date)
	{
		System.out.println(email+" "+date);
		ServiceCenter center = centerRepo.findByEmail(email);
		System.out.println(center.getId());
		
		
		List<BookingTable> list= bookingRepo.getTodaysBooking(center,date);
		System.out.println(list);
		return list;
	}
	
	//to see list of booking by date
	public List<BookingTable> bookingHistory(String startdate, String enddate, String email)
	{
		ServiceCenter center = centerRepo.findByEmail(email);
		return bookingRepo.bookingHistory(center,startdate,enddate);
	}
	
	//to update bookings {via booking table controller}
	public BookingTable updateBooking(BookingTable updatedBooking)
	{
		int bookingId = updatedBooking.getbookingId();
		Optional<BookingTable> booking=bookingRepo.findById(bookingId);
		booking.get().setBookingDate(updatedBooking.getBookingDate());
		booking.get().setmodelNo(updatedBooking.getmodelNo());
		booking.get().setstatus(updatedBooking.getstatus());
		booking.get().settotalCost(updatedBooking.gettotalCost());
		booking.get().setvehicleRegNo(updatedBooking.getvehicleRegNo());
		
		BookingTable upBooking = bookingRepo.save(booking.get());
		return upBooking;
	}
	
	//to delete bookings
	public String deleteBooking(int bookingId)
	{
		BookingTable booking = bookingRepo.findById(bookingId).get();
		bookingRepo.delete(booking);
		return "deleted";
	}


	
	
	
	
}