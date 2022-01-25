package com.snehal.carservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.persistable.VehiclePersistable;
@Repository
public interface VehicleRepository extends JpaRepository<VehiclePersistable, Long> {

}
