package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.MechanicRepository;
import com.app.dao.VehicleRepository;
import com.app.entities.Mechanic;
import com.app.entities.Vehicle;
import com.app.service.IUserService;


@RestController
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired
	private VehicleRepository vrepo;
	
	@Autowired
	private IUserService uservice;
	
	@Autowired
	private MechanicRepository mrepo;
	
	
	
	//to get all vehicle without mid
	@RequestMapping("/admin")
		public ResponseEntity<?> alldeatils(){
		System.out.println("in list all details");
			List<Vehicle> list = vrepo.getmidnullVehicles();
			//o.s.ResponseEntity(T body,HttpStatus sts)
			if (list.isEmpty())
				return new ResponseEntity<>("Empty Vehicle List !!!!", HttpStatus.OK);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	
	//to assign veh to mid{not working}
	@PostMapping("/admin/{mid}/{vid}")//not woring
	public ResponseEntity<?> updateVehicle(@PathVariable int mid,@PathVariable int vid){
		System.out.println("in vechicle update");
		Vehicle vehicle=vrepo.updatewithMid(mid, vid);
		//Vehicle v=vservice.updateVehicle(vehicle);
		return new ResponseEntity<>(vehicle, HttpStatus.OK);
	}
	
	//for deleting user
	@DeleteMapping("/admin/{uid}")
	public String deleteUser(@PathVariable int uid){
		System.out.println("in user delete method");
		return uservice.deleteUsers(uid);
	}
	
	
	//to get all mechnic with status false i.e mech is free
	@GetMapping("/admin/fmech")
	public ResponseEntity<?> getfreeMech(){
	System.out.println("in list all details");
		List<Mechanic> list = mrepo.getMechByStatus();
		//o.s.ResponseEntity(T body,HttpStatus sts)
		if (list.isEmpty())
			return new ResponseEntity<>("Empty Vehicle List !!!!", HttpStatus.OK);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	

}
