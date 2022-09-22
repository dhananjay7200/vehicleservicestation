package com.app.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.VehicleRepository;
import com.app.dto.UserDTO;
import com.app.dto.VehicleDTO;
import com.app.entities.User;
import com.app.entities.Vehicle;
@Service
@Transactional
public class VehicleServiceImpl implements IVehicleService {
	

	@Autowired
	private VehicleRepository vrepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	//used in admin controller to get all vehicle 
	@Override
	public List<Vehicle> getalldetails() {
		
		return vrepo.findAll();
	}
	
	//used in mechanical contrller to get veh by mid need to uuse query
	@Override
	public Optional<Vehicle> getVehicle(int mid) {
		
		return vrepo.findById(mid);
	}
	
	//used in vehicle controller save vehicle
	@Override
	public VehicleDTO addVehicleDetails(VehicleDTO vehicledto) {
		//using mapper to map dto to entity
				Vehicle v=mapper.map(vehicledto, Vehicle.class);
				Vehicle pervehicle=vrepo.save(v);
				return mapper.map(pervehicle, VehicleDTO.class);
		
	}

	//used in vehicle controller to delete vehicle
	@Override
	public String deleteVehDetails(int vid) {
		// TODO Auto-generated method stub
		String mesg = "Deletion of Vehicle details failed!!!!!!!!!!!";
		if (vrepo.existsById(vid)) {
			vrepo.deleteById(vid);
			mesg = "Vehicle details deleted successfully , for vid id :" + vid;
		}

		return mesg;
	}

	//used in vehicle controller to update
	@Override
	public Vehicle updateVehicle(Vehicle v) {
		// TODO Auto-generated method stub
		return vrepo.save(v);
	}

	
	
	
}
