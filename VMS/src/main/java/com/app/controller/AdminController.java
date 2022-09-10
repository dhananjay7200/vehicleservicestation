package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Vehicle;
import com.app.service.IVehicleService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private IVehicleService vservice;
	
	@GetMapping
		public ResponseEntity<?> alluserdeatils(){
			System.out.println("in list all details");
			List<Vehicle> list = vservice.getalldetails();
			// o.s.ResponseEntity(T body,HttpStatus sts)
			if (list.isEmpty())
				return new ResponseEntity<>("Empty Emp List !!!!", HttpStatus.OK);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}

	
}
