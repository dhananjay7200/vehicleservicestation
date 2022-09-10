package com.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.app.entities.User;
import com.app.entities.Vehicle;
//import com.app.service.IUserService;
import com.app.service.IVehicleService;

@RestController // MANDATORY : composed of @Controller at the cls level + @ResponseBody(for
// marshalling : java ---> json) addedd implicitly on ret types of all req
// handling methods , annotated by @ReqMapping / @GetMapping .......
@RequestMapping("/api/user")

//@Validated
public class UserController {
	@Autowired
	private IVehicleService vservice;
	
	//@Autowired
	//private IUserService uservice;
	
	public UserController() {
		System.out.print("in user controller");
	}
	
	//@GetMapping
	//public ResponseEntity<?> alldeatils(){
	//System.out.println("in list all details");
		//List<Vehicle> list = vservice.getalldetails();
		// o.s.ResponseEntity(T body,HttpStatus sts)
		//if (list.isEmpty())
		//	return new ResponseEntity<>("Empty Emp List !!!!", HttpStatus.OK);
		//return new ResponseEntity<>(list, HttpStatus.OK);
	//}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDetails(@PathVariable int id) {
		System.out.println("in list emps");
		Optional<Vehicle> list = vservice.getVehicle(id);
		// o.s.ResponseEntity(T body,HttpStatus sts)
		if (list.isEmpty())
			return new ResponseEntity<>("Empty Emp List !!!!", HttpStatus.OK);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
