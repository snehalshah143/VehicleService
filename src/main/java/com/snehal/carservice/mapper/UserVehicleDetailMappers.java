package com.snehal.carservice.mapper;

import com.snehal.carservice.model.domain.UserVehicleDetail;
import com.snehal.carservice.model.dto.UserVehicleDetailJsonDto;
import com.snehal.carservice.model.persistable.UserVehicleDetailPersistable;

public class UserVehicleDetailMappers extends AbstarctMapper<UserVehicleDetailJsonDto, UserVehicleDetail, UserVehicleDetailPersistable>{

	private static UserVehicleDetailMappers userVehicleDetailMappers=new UserVehicleDetailMappers();

	public static UserVehicleDetailMappers getUserVehicleDetailMappers() {
		return userVehicleDetailMappers;
	}
	
	public UserVehicleDetailJsonDto  mapPersistableToJsonDto(UserVehicleDetailPersistable persistable) {
		
		UserVehicleDetailJsonDto jsonDto= modelMapper.map(persistable, UserVehicleDetailJsonDto.class);
		return jsonDto;
		
	}
}
