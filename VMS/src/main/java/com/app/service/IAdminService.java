package com.app.service;

import java.util.Optional;

import com.app.entities.Vehicle;

public interface IAdminService {
	Optional<Vehicle> getallVechicle();
	
}
