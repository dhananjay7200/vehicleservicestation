package com.app.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
//Find all emps drawing salary > specific value
	//List<User> findBySalaryGreaterThan(double salary);
	// Find all emps from specific department n location
	//List<Employee> findByDepartmentAndWorkLocation(String dept,String loc);
	//Apply increment to  employee's salary for a specific department : using bulk update approach
	//@Query("update Employee e set e.salary=e.salary+?1 where e.department=?2")
	//@Modifying //MANDATORY for DML
	//int updateEmpSalaryByDept(double salIncr,String deptName);
	
	//to get mech with id(mechanic controller)
			@Query(value="Select * from users where uid=?1",nativeQuery=true)
			User getUserDetails(int id);
	
}
