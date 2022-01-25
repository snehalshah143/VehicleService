package com.snehal.carservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.persistable.UserVehicleDetailPersistable;
@Repository
public interface UserVehicleDetailRepository extends JpaRepository<UserVehicleDetailPersistable, Long> {

//	UserVehicleDetail getUserVehicleDetail(Long detailId);
	UserVehicleDetailPersistable findByDetailId(Long detailId);
	
//	@Query(value="select d from user_vehicle_detail d join appuser u where u.user_id= :user_id", nativeQuery = true )
//	@Query("from user_vehicle_detail u where u.user_id = :user_id" )
//	List<UserVehicleDetail> findAllByUserId( @Param("user_id") Long userId);
}
