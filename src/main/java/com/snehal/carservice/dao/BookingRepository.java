package com.snehal.carservice.dao;

import com.snehal.carservice.model.persistable.BookingPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingPersistable, Long> {

  //	Booking getUserVehicleDetails(Long detailId);

}
