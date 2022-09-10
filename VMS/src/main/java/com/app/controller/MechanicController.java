package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Vehicle;
import com.app.service.IVehicleService;

@RestController
@RequestMapping("/api/mechanic")
public class MechanicController {
	@Autowired
	private IVehicleService vservice;
	
	@GetMapping("/{id}")
		public ResponseEntity<?> alluserdeatils(@PathVariable int id){
			System.out.println("in list all details");
			Optional<Vehicle> list = vservice.getVehicle(id);
			// o.s.ResponseEntity(T body,HttpStatus sts)
			if (list.isEmpty())
				return new ResponseEntity<>("Empty Emp List !!!!", HttpStatus.OK);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}

}
