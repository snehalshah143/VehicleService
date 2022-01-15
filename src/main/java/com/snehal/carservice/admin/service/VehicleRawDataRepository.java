package com.snehal.carservice.admin.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRawDataRepository extends JpaRepository<VehicleRawData, Long> {

}
