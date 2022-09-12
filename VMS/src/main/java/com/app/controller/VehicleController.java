package com.app.controller;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.VehicleRepository;
import com.app.dto.VehicleDTO;
import com.app.entities.Vehicle;
import com.app.service.IVehicleService;

@RestController 
@RequestMapping("/api/vehicle")
public class VehicleController {
	@Autowired
	private IVehicleService vservice;
	
	@Autowired
	private VehicleRepository vrepo;
	
	//save vehicle
		@PostMapping
		public ResponseEntity<VehicleDTO> addVehicleDetails(@RequestBody @Valid VehicleDTO vehicle){
			System.out.println("in save Vehicle " + vehicle);
			return new ResponseEntity<>(vservice.addVehicleDetails(vehicle), HttpStatus.CREATED);
			
		}
		
		//update {not working}
		@PutMapping
		public Vehicle updateVehicleDetails(@RequestBody Vehicle vehicle) {
			System.out.println("in updateVehicle " + vehicle);// id not null
			return vservice.updateVehicle(vehicle);
		}
		
		//delete vehicle
		@DeleteMapping("/delete/{vid}") // can use ANY name for a path var.
		// @PathVariable => a binding between a path var to method arg.
		public String deleteVehicleDetails(@PathVariable @Range(min = 1, max = 100, message = "Invalid Vehicle id!!!") int vid) 
		{
			System.out.println("in del Vehicle " + vid);
			return vservice.deleteVehDetails(vid);
		}
		
		//get vehicle by id
		@GetMapping("/{vid}")
		// @PathVariable => a binding between a path var to method arg.
		public ResponseEntity<?> getVechDetails(@PathVariable int vid) {
			System.out.println("in get veh " + vid);
			Vehicle veh = vrepo.getVehicleWithvid(vid);
			//System.out.println("emp class " + employee.getClass());
			return ResponseEntity.ok(veh);
		}

	

}
