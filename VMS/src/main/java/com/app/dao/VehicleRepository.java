package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
	//Apply increment to  employee's salary for a specific department : using bulk update approach
	//@Query("update Employee e set e.salary=e.salary+?1 where e.department=?2")
	//@Modifying //MANDATORY for DML
	//int updateEmpSalaryByDept(double salIncr,String deptName);
	//@Query("select vname,reg_number  from vehicles where uid=?1")
	//List<Vehicle> getVechiclebyuid(int uid);
	
	
	//for vehicle without mid(admin controller)
	@Query(value="Select * from vehicles where m_id IS NULL",nativeQuery=true)
	List<Vehicle> getmidnullVehicles();
	
	//to get mech with id(mechanic controller)
	@Query(value="Select * from vehicles where m_id=?1",nativeQuery=true)
	Optional<Vehicle> getVehicleWithMid(int id);
	
	//to get vech with id(vehicle controller)
		@Query(value="Select * from vehicles where vid=?1",nativeQuery=true)
		Vehicle getVehicleWithvid(int id);
	
	
}
