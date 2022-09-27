package com.vssm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.vssm.entity.Customer;
import com.vssm.repository.CustomerRepository;

@Component
public class CustomerDao {
	      private CustomerRepository customerRepo;
	      public  CustomerDao()
	      {
	    	  
	      }
	      @Autowired
	      public CustomerDao(CustomerRepository  customerRepo)
	      {
	    	  this.customerRepo=customerRepo;
	      }
	      
	    //register via customer controller
	       public Customer registerCustomer(Customer customer)
	       {
	    	    return customerRepo.save(customer);
	       }
	       
	       
	       
	       
	       //to check security que vis customer controller
	       public ResponseEntity<?> validateSecurityAnswer(String email,String answer)
	       {
	    	   System.out.println(answer);
	    	   Customer customer=customerRepo.findByEmail(email);
	    	   System.out.println(customer);
	    	    if(customer!=null)
	    	    {
	    	    	String customerOriginalAns=customer.getSecurityAnswer();
	    	    	System.out.println(customerOriginalAns);
	    	    	if( customerOriginalAns.equals(answer))
	    	    	{
	    	    		System.out.println("send ans"+answer+"databse ans"+customerOriginalAns);
	    	    		return new ResponseEntity<>(HttpStatus.OK);
	    	    	}
	    	    } 
	    	    		return new ResponseEntity<>("inValid ans",HttpStatus.UNAUTHORIZED);


	       }
	       //to reset password
	       public ResponseEntity<?> ResetUserPassword(String email,String password)
	       {
	    	   Customer customer=customerRepo.findByEmail(email);
	    	    customer.setPassword(password);
	    	    customerRepo.save(customer);

	    	    return new ResponseEntity<>(HttpStatus.OK);




	       }
}
