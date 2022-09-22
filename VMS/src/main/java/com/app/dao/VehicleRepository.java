package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
	
	
	//for vehicle without mid(admin controller)
	@Query(value="Select vid,problem,reg_number,vname,m_id from vehicles where m_id IS NULL",nativeQuery=true)
	List<Vehicle> getmidnullVehicles();
	
	//to get mech with id(mechanic controller)
	@Query(value="Select * from vehicles where m_id=?1",nativeQuery=true)
	Optional<Vehicle> getVehicleWithMid(int id);
	
	//to get vech with id(vehicle controller)
		@Query(value="Select * from vehicles where vid=?1",nativeQuery=true)
		Vehicle getVehicleWithvid(int id);
		
		//to assign vehcle to mechanic
		@Query(value="update vehicles v set v.m_id =?1 where v.vid =?2",nativeQuery=true)
		@Modifying
		Vehicle updatewithMid(int mid,int vid);
	
	
}
