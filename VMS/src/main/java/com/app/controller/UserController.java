package com.app.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UserRepository;
import com.app.dto.UserDTO;
import com.app.entities.User;
import com.app.service.IUserService;

@RestController 
@RequestMapping("/home")
//@Validated
public class UserController {
	@Autowired
	private IUserService uservice;
	
	@Autowired
	private UserRepository urepo;
	
	public UserController() {
		System.out.print("in user controller");
	}
	
	//find by id
		@GetMapping("/{id}")
		// @PathVariable => a binding between a path var to method arg.
		public ResponseEntity<?> getUserDetails(@PathVariable int id) {
			System.out.println("in get emp " + id);
			User user =urepo.getUserDetails(id);		
			return ResponseEntity.ok(user);
		}
	
		
	//save user info
	@PostMapping("/")
	public ResponseEntity<UserDTO> addUserDetails(@RequestBody @Valid UserDTO user){
		System.out.println("in save user " + user);
		return new ResponseEntity<>(uservice.saveUserDetails(user), HttpStatus.CREATED);
		
	}
	
	//update user info
	@PutMapping
	public User updateUserDetails(@RequestBody User user) {
		System.out.println("in update User " + user);// id not null
		return uservice.updateUser(user);
	}
	
	

	
	

}
