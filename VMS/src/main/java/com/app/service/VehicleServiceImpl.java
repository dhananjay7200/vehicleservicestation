package com.app.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.VehicleRepository;
import com.app.entities.Vehicle;
@Service
@Transactional
public class VehicleServiceImpl implements IVehicleService {
	@Autowired
	private VehicleRepository vrepo;
	@Override
	public List<Vehicle> getalldetails() {
		
		return vrepo.findAll();
	}
	
	@Override
	public Optional<Vehicle> getVehicle(int vid) {
		
		return vrepo.findById(vid);
	}
	

}
