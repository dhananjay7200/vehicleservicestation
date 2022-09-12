package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.VehicleRepository;
import com.app.entities.Vehicle;
import com.app.service.IVehicleService;

@RestController
@RequestMapping("/api/mechanic")
public class MechanicController {
	
	@Autowired
	private IVehicleService vservice;
	
	@Autowired
	private VehicleRepository vrepo;
	
	//Mechanic will see the list of vehicle he is assign
	
	@GetMapping("/{id}")
		public ResponseEntity<?> getDetails(@PathVariable int id) {
			System.out.println("in list veh");
			Optional<Vehicle> list = vrepo.getVehicleWithMid(id);
			if (list.isEmpty())
				return new ResponseEntity<>("Empty Emp List !!!!", HttpStatus.OK);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	
	
	

}
