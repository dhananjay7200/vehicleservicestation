package com.app.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserRepository;
import com.app.dao.VehicleRepository;
import com.app.dto.UserDTO;
import com.app.entities.User;
import com.app.entities.Vehicle;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private VehicleRepository vrepo;
	
	@Autowired 
	private UserRepository urepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<User> alluser() {
		// TODO Auto-generated method stub
		return urepo.findAll();
	}
	
	//
	@Override
	public Optional<Vehicle> getVechicleDetails(int uid) {
		// TODO Auto-generated method stub
		return vrepo.findById(uid);
	}
	
	//save details
	@Override
	public UserDTO saveUserDetails(UserDTO userdto) {
		//using mapper to map dto to entity
		User user=mapper.map(userdto, User.class);
		User peruser=urepo.save(user);
		return mapper.map(peruser, UserDTO.class);
	}
	//update details
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return urepo.save(user);
	}
	
	@Override
	public String deleteUsers(int uid) {
		String mesg = "Deletion of user details failed!!!!!!!!!!!";

		if (urepo.existsById(uid)) {
			urepo.deleteById(uid);
			mesg = "User details deleted successfully , for emp id :" + uid;
		}

		return mesg;
	}
	
	@Override
	public String[] getEmailById(int id) {
		// TODO Auto-generated method stub
		return urepo.getEmailId(id);
	}
	}
	
	
	
	
	
	
	

