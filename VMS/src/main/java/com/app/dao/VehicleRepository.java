package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
//Find all emps drawing salary > specific value
	//List<User> findBySalaryGreaterThan(double salary);
	// Find all emps from specific department n location
	//List<Employee> findByDepartmentAndWorkLocation(String dept,String loc);
	//Apply increment to  employee's salary for a specific department : using bulk update approach
	//@Query("update Employee e set e.salary=e.salary+?1 where e.department=?2")
	//@Modifying //MANDATORY for DML
	//int updateEmpSalaryByDept(double salIncr,String deptName);
	
}
