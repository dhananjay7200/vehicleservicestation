package com.vssm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vssm.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByEmail(String email);

}
