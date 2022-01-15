package com.snehal.carservice.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.common.model.UserVehicleDetail;
@Repository
public interface UserVehicleDetailRepository extends JpaRepository<UserVehicleDetail, Long> {

//	UserVehicleDetail getUserVehicleDetail(Long detailId);
	UserVehicleDetail findByDetailId(Long detailId);
}
