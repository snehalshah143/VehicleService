package com.snehal.carservice.mapper;

import java.util.HashSet;
import java.util.Set;

import com.snehal.carservice.model.domain.AppUser;
import com.snehal.carservice.model.dto.AppUserJsonDto;
import com.snehal.carservice.model.dto.BookingJsonDto;
import com.snehal.carservice.model.dto.UserSignUpRequest;
import com.snehal.carservice.model.dto.UserVehicleDetailJsonDto;
import com.snehal.carservice.model.persistable.AppUserPersistable;
import com.snehal.carservice.model.persistable.BookingPersistable;
import com.snehal.carservice.model.persistable.UserVehicleDetailPersistable;

public class AppuserMappers extends AbstarctMapper<AppUserJsonDto, AppUser, AppUserPersistable>{

	private static AppuserMappers AppuserMappers=new AppuserMappers();

	public static AppuserMappers getAppuserMappers() {
		return AppuserMappers;
	}
	
	public AppUserJsonDto  mapPersistableToJsonDto(AppUserPersistable persistable) {
		AppUserJsonDto appUserJsonDto=new AppUserJsonDto();
		appUserJsonDto.setUserId(persistable.getId());
		appUserJsonDto.setFirstName(persistable.getFirstName());
		appUserJsonDto.setLastName(persistable.getLastName());
		appUserJsonDto.setEmail(persistable.getEmail());
		appUserJsonDto.setMobileNumber(persistable.getMobileNumber());
		appUserJsonDto.setUsername(persistable.getUsername());
		if(persistable.getBookings()!=null) {
		Set<BookingJsonDto> bookingsJsonDtoSet=new HashSet<BookingJsonDto>();
		for(BookingPersistable b:persistable.getBookings()) {
			bookingsJsonDtoSet.add(BookingMappers.getBookingMappers().mapPersistableToJsonDto(b));
		}
		appUserJsonDto.setBookings(bookingsJsonDtoSet);
		}
		if(persistable.getVehicleDetails()!=null) {
		Set<UserVehicleDetailJsonDto> userVehicleDetailJsonDtoSet=new HashSet<UserVehicleDetailJsonDto>();
		for(UserVehicleDetailPersistable u:persistable.getVehicleDetails()) {
			userVehicleDetailJsonDtoSet.add(UserVehicleDetailMappers.getUserVehicleDetailMappers().mapPersistableToJsonDto(u));
		}
		appUserJsonDto.setVehicleDetails(userVehicleDetailJsonDtoSet);
		}
		return appUserJsonDto;
		
	}
	
	public AppUserPersistable  mapSignUpRequestToPersistable(UserSignUpRequest request) {
	
		AppUserPersistable persistable=new AppUserPersistable();
		persistable.setEmail(request.getEmail());
		persistable.setFirstName(request.getFirstName());
		persistable.setLastName(request.getLastName());
		persistable.setMobileNumber(request.getMobileNumber());
		persistable.setPassword(request.getPassword());
		
		return persistable;
	
	}
}
