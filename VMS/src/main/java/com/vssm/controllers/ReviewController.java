package com.vssm.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vssm.dao.ReviewDao;
import com.vssm.entity.Review;

@CrossOrigin
@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewDao dao;
	
	
	@PostMapping("/addReview")
	public Review addReview(@RequestBody Review review)
	{
		return dao.addReview(review);
	}
	
	@GetMapping("/getCenterReview/{city}/{centerName}")
	public List<Review> getCenterReview(@PathVariable String city, @PathVariable String centerName)
	{
		return dao.getByCenter(city,centerName);
	}
	
	
	
//	@GetMapping("/Getreview/{bookingId}")
//	public Review Review(@PathVariable int bookingId)
//	{
//		return dao.getReview(bookingId);	
//	}
//	
//	@GetMapping("/getAll/{bookingId}")
//	public List<Review> Review1(int bookingId) {
//		List<Review> li = (List<Review>) dao.getReview(bookingId);
//		return li;
//	}
	
//	@GetMapping("/getAll")
//	 public List<ServiceCenter> serviceCenter()
//	 {
//		 ArrayList<ServiceCenter> list =  (ArrayList<ServiceCenter>) dao.GetAll();
//		 return list;
	// }
}
