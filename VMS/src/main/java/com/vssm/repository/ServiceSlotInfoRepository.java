package com.vssm.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.vssm.entity.ServiceCenter;
import com.vssm.entity.ServiceSlotInfoTable;

@Repository
public interface ServiceSlotInfoRepository extends JpaRepository<ServiceSlotInfoTable, Integer> {

	
	//to update slot{after booking in bookingtable dao}
	@Transactional
	@Modifying
	@Query("update ServiceSlotInfoTable s set s.remainingSlot =s.remainingSlot-1 where s.center=:center and date=:date")
	void upDateSlot(@Param("center") ServiceCenter center,@Param("date")String date );
	
	//
	 @Query("select c from ServiceSlotInfoTable c where date = :date and service_center_id = :id")
		ServiceSlotInfoTable getByDateAndRegNo(@Param("date") String date,@Param("id") int id);
	 
	 
	 @Query("select c from ServiceSlotInfoTable c where date=:date and center.email=:email")
		ServiceSlotInfoTable getByDateAndEmail(@Param("date") String date, @Param("email") String email);

	 
	 
	 
	 
	 
	 
	 
	 
}