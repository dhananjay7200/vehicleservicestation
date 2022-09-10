package com.app.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserRepository;
import com.app.dao.VehicleRepository;
import com.app.entities.User;
import com.app.entities.Vehicle;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	

	@Autowired
	private VehicleRepository vrepo;
	@Autowired 
	private UserRepository urepo;
	
	@Override
	public List<User> alluser() {
		// TODO Auto-generated method stub
		return urepo.findAll();
	}
	@Override
	public Optional<Vehicle> getVechicleDetails(int uid) {
		// TODO Auto-generated method stub
		return vrepo.findById(uid);
	}
	
	
	
	
}
