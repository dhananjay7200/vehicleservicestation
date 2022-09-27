package com.vssm.securityConfigration;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vssm.entity.Admin;
import com.vssm.entity.Customer;
import com.vssm.repository.AdminRepository;
import com.vssm.repository.CustomerRepository;
import com.vssm.repository.ServiceCenterRepository;

//
@Service
public class AdminDetailsService implements UserDetailsService {
	
	private AdminRepository adminRepo;

	@Autowired
	public  AdminDetailsService(AdminRepository adminRepo)
	{
		this.adminRepo=adminRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		
		 
		System.out.println("checking inside customer table");
	//	customerRepo.save(new Customer("dhananjay","khuje","sdad","sda","SADds","sadasd"));
	List<Admin> list= adminRepo.findAll();
		 System.out.println("no of element in customer database"+list.size());
		   
		//Customer cust= customerRepo.findById(1).get();
		//System.out.println("afte finding "+cust);
	Admin user = adminRepo.findByEmail(email);
	  
	System.out.println("after finding by email"+user);
	if (user != null) {
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 String encodedPassword = passwordEncoder.encode(user.getPassword());
		roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		return new User(user.getEmail(), encodedPassword, roles);
	}
	throw new UsernameNotFoundException("User not found with the name " );	
	
	}
}


