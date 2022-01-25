package com.snehal.carservice.mapper;

import com.snehal.carservice.model.domain.UserVehicleDetail;
import com.snehal.carservice.model.dto.AppUserJsonDto;
import com.snehal.carservice.model.dto.UserVehicleDetailJsonDto;
import com.snehal.carservice.model.persistable.AppUserPersistable;
import com.snehal.carservice.model.persistable.UserVehicleDetailPersistable;

public class UserVehicleDetailMappers extends AbstarctMapper<UserVehicleDetailJsonDto, UserVehicleDetail, UserVehicleDetailPersistable>{

	private static UserVehicleDetailMappers userVehicleDetailMappers=new UserVehicleDetailMappers();

	public static UserVehicleDetailMappers getUserVehicleDetailMappers() {
		return userVehicleDetailMappers;
	}
	
	public UserVehicleDetailJsonDto  mapPersistableToJsonDto(UserVehicleDetailPersistable persistable) {
		
		UserVehicleDetailJsonDto userVehicleDetailJsonDto=new UserVehicleDetailJsonDto();
		userVehicleDetailJsonDto.setDetailId(persistable.getId());
		userVehicleDetailJsonDto.setVehicleSegment(persistable.getVehicleSegment());
		userVehicleDetailJsonDto.setVehicleNumber(persistable.getVehicleNumber());
		
		userVehicleDetailJsonDto.setAddress(persistable.getAddress());
		AppUserPersistable appUserPersistable=persistable.getAppUser();
		AppUserJsonDto appUserJsonDto=new AppUserJsonDto();
		appUserJsonDto.setUserId(appUserPersistable.getId());
		userVehicleDetailJsonDto.setAppUser(appUserJsonDto);
		userVehicleDetailJsonDto.setLocality(persistable.getLocality());
		userVehicleDetailJsonDto.setManufacturingCompanyAndModel(persistable.getManufacturingCompanyAndModel());
		userVehicleDetailJsonDto.setParkingPlace(persistable.getParkingPlace());
		userVehicleDetailJsonDto.setPincode(persistable.getPincode());
		userVehicleDetailJsonDto.setSociety(persistable.getSociety());
		//UserVehicleDetailJsonDto jsonDto= modelMapper.map(persistable, UserVehicleDetailJsonDto.class);
		return userVehicleDetailJsonDto;
		
	}
}
