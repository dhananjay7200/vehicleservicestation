package com.app.service;


import java.util.List;
import java.util.Optional;

import com.app.entities.Vehicle;

public interface IVehicleService {
	Optional<Vehicle> getVehicle(int id);
	List<Vehicle> getalldetails();
}
