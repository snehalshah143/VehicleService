package com.snehal.carservice.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.common.model.UserVehicleDetail;
@Repository
public interface UserVehicleDetailRepository extends JpaRepository<UserVehicleDetail, Long> {

//	UserVehicleDetail getUserVehicleDetail(Long detailId);
	UserVehicleDetail findByDetailId(Long detailId);
	
	@Query(value="select u from user_vehicle_detail u where u.user_id= :user_id", nativeQuery = true )
	List<UserVehicleDetail> getUserVehicleDetailsForUserId( @Param("user_id") Long userId);
}
