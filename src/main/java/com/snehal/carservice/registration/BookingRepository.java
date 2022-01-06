package com.snehal.carservice.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.Booking;



@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
//	Booking getUserVehicleDetails(Long detailId);
	


}
