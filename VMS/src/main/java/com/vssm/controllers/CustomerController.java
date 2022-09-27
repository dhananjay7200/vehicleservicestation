package com.vssm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vssm.dao.CustomerDao;
import com.vssm.entity.Customer;

@CrossOrigin
@RestController
@RequestMapping(path="/customer")
public class CustomerController {
	
		@Autowired
	    private CustomerDao dao;
	    
		//to resister
	    @PostMapping("/register")
	    public Customer register(@RequestBody Customer customer)
	    {
	    	return dao.registerCustomer(customer);
	    }
	    
	    
	    
	    
	    //forgot password
	    @PostMapping("/forgetPaswword/{email}/{securityAnswer}")
	    public ResponseEntity<?> validateAnswer(@PathVariable String email,@PathVariable String securityAnswer)
	    {
	    	System.out.println(email);
	    	return dao.validateSecurityAnswer(email, securityAnswer);
	    }
	    
	    //to reset password
	    @PostMapping("setpassword/{email}/{password}")
	    public ResponseEntity<?> ResetPassword(@PathVariable String email,@PathVariable String password)
	    {
	    	return dao.ResetUserPassword(email, password);
	    }
	    
}
