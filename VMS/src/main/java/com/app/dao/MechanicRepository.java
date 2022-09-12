package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Mechanic;
import com.app.entities.Vehicle;

public interface MechanicRepository extends JpaRepository<Mechanic,Integer> {
	
	//to get free mech (engineer controller)
	@Query(value="Select * from mechanics where status=0",nativeQuery=true)
	public List<Mechanic> getMechByStatus();

}
