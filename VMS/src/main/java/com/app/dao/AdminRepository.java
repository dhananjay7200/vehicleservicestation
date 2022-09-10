package com.app.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.app.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
//Find all vehiclw without eid
	//List<Vehicle> findbyeidisnull();
	
	//Apply update to vechicle table with mid
	//@Query("update Vehicle v set v.eid=?1 where v.mid=null")
	//@Modifying //MANDATORY for DML
	//int updateVechiclebyeid(Integer eid);
	
}
