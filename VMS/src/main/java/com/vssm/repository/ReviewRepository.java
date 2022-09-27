package com.vssm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vssm.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

	Review findByBookingId(int id);

	@Query("select c from Review c where c.bookingId.bookingId=:bookingId")
	Review getByBooking(@Param("bookingId") int bookingId);




}