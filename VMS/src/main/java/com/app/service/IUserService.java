package com.app.service;


import java.util.List;
import java.util.Optional;

import com.app.entities.User;
import com.app.entities.Vehicle;

public interface IUserService {
//get all emps
	Optional<Vehicle> getVechicleDetails(int uid);
	List<User> alluser();
	
}
