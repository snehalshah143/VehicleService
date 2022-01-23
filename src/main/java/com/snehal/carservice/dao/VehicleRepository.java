package com.snehal.carservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
