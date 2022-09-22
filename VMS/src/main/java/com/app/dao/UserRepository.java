package com.app.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.app.entities.User;


public interface UserRepository extends JpaRepository<User,Integer> {
	
	// to get user by id
		@Query(value="Select * from users where uid=?1",nativeQuery=true)
		User getUserDetails(int id);
		
		//get by email id
		@Query(value="select * from users u where u.email_id=?1",nativeQuery=true)
		User getUserByUseName(String email);
		
		@Query(value="select * from users u join fetch u.roles where u.email=?1",nativeQuery=true)
		Optional<User> findByEmail(String email);
		
		//to get email for sending email
		@Query(value="select email_id from users where uid=?1",nativeQuery=true)
		String[] getEmailId(int id);
		
		
		
	
}
