package com.app.service;


import java.util.List;
import java.util.Optional;

import com.app.dto.UserDTO;
import com.app.dto.VehicleDTO;
import com.app.entities.User;
import com.app.entities.Vehicle;

public interface IVehicleService {
	Optional<Vehicle> getVehicle(int id);
	List<Vehicle> getalldetails();
	Vehicle getvehiclebyid(int id);
	//Vehicle_History addvehicle(Vehicle_History v);
	//Vehicle addvehicle(Vehicle v);
	VehicleDTO addVehicleDetails(VehicleDTO vehicle);
	
	String deleteVehDetails(int vid);
	Vehicle updateVehicle(Vehicle v);
	
}
