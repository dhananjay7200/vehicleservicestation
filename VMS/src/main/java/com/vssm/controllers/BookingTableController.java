package com.vssm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vssm.dao.BookingTableDao;
import com.vssm.dao.ServiceSlotInfoDao;
import com.vssm.entity.BookingTable;
import com.vssm.entity.Customer;
import com.vssm.entity.ServiceCenter;
import com.vssm.entity.ServiceSlotInfoTable;
import com.vssm.repository.CustomerRepository;
import com.vssm.repository.ServiceCenterRepository;
import com.vssm.securityConfigration.CustomJwtAuthenticationFilter;
import com.vssm.securityConfigration.JwtUtil;

@CrossOrigin
@RestController
@RequestMapping(path = "/booking")
public class BookingTableController {

	@Autowired
	private BookingTableDao dao;
	@Autowired
	private ServiceSlotInfoDao slotDao;



	//for new bookings 
	@PostMapping("/newbooking")
	public ResponseEntity<String> addBooking(@RequestBody BookingTable bookingObject)
	{
		//String jwtToken =  authObjet.extractJwtFromRequest(request);
		//UserDetails userDetails = new User(jwtTokenUtil.getUsernameFromToken(jwtToken)
		return dao.addBookingDetails(bookingObject);
	}
	
		
	// get using email email
	@GetMapping("/getTodaysBooking/{email}/{date}")
	public List<BookingTable> getTodaysBooking(@PathVariable String email, @PathVariable String date)
	{
		return dao.getTodaysBooking(email,date);
	}
	
	//email
	//get bookingHistory from bookingTable using 2 dates and service centerName
	@GetMapping("/bookingHistory/{startdate}/{enddate}/{email}")
	public List<BookingTable> getHistory(@PathVariable String startdate, @PathVariable String enddate, @PathVariable String email)
	{
		return dao.bookingHistory(startdate,enddate,email);
	}
	
	
	@PutMapping("/updateBooking")
	public BookingTable updateBooking(@RequestBody BookingTable updatedBooking)
	{
		return  dao.updateBooking(updatedBooking);
	}
	
	
	@DeleteMapping("/deleteBooking/{bookingId}")
	public String deleteBooking(@PathVariable int bookingId)
	{
		System.out.println(bookingId);
		return dao.deleteBooking(bookingId);
	}



}
