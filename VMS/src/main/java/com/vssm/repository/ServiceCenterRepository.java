package com.vssm.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vssm.entity.ServiceCenter;

@Repository
public interface ServiceCenterRepository extends JpaRepository <ServiceCenter,Integer>{
	//to find service centre by name
	ServiceCenter findByName(String Name);
	
	//to find service centre by reg no{booking table dao,}
	ServiceCenter findByRegNo(int regNo);
	
	ServiceCenter findByEmail(String email);
	
	@Modifying
	@Query("update ServiceCenter set capacity=:slots where registration_no=:regNo")
	void changeSlots(@Param("regNo") int regNo, @Param("slots") int slots);

	
	@Query("select distinct city from ServiceCenter")
	ArrayList<String> getCitiesAll();
	
	@Query("select c from ServiceCenter c")
	ArrayList<ServiceCenter> getCityCenters(@Param("city") String city);
	

	//select *from service_center_details where city="pune" and name="omsai";
			@Query("select c from ServiceCenter c where c.city=:city and c.name=:centerName")
			ServiceCenter findByCityCenter(@Param("city") String city, @Param("centerName") String centerName);

	

}
