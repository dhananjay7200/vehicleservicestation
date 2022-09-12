package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.MechanicRepository;
import com.app.entities.Mechanic;

@RestController
@RequestMapping("/api/engineer")
public class EngineerController {
	
	@Autowired
	private MechanicRepository mrepo;
	
	//to get all mechnic with status false i.e mech is free
		@GetMapping
			public ResponseEntity<?> getfreeMech(){
			System.out.println("in list all details");
				List<Mechanic> list = mrepo.getMechByStatus();
				//o.s.ResponseEntity(T body,HttpStatus sts)
				if (list.isEmpty())
					return new ResponseEntity<>("Empty Vehicle List !!!!", HttpStatus.OK);
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
	

}
