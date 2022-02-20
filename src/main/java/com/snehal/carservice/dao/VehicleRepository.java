package com.snehal.carservice.dao;

import com.snehal.carservice.model.persistable.VehiclePersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehiclePersistable, Long> {}
