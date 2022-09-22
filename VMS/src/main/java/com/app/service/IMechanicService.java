package com.app.service;

import java.util.List;

import com.app.entities.Vehicle;

public interface IMechanicService {
	List<Vehicle> getVehiclebymid(int mid);

}
