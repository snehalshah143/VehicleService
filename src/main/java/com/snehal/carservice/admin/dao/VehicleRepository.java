package com.snehal.carservice.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.common.model.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
