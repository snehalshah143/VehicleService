package com.snehal.carservice.mapper;

import java.util.HashSet;
import java.util.Set;

import com.snehal.carservice.common.util.DateTimeUtil;
import com.snehal.carservice.model.domain.Employee;
import com.snehal.carservice.model.dto.AppUserJsonDto;
import com.snehal.carservice.model.dto.BookingJsonDto;
import com.snehal.carservice.model.dto.EmployeeJsonDto;
import com.snehal.carservice.model.dto.EmployeeSignUpRequest;
import com.snehal.carservice.model.dto.UserSignUpRequest;
import com.snehal.carservice.model.dto.UserVehicleDetailJsonDto;
import com.snehal.carservice.model.persistable.AppUserPersistable;
import com.snehal.carservice.model.persistable.BookingPersistable;
import com.snehal.carservice.model.persistable.EmployeePersistable;
import com.snehal.carservice.model.persistable.UserVehicleDetailPersistable;

public class EmployeeMappers extends AbstarctMapper<EmployeeJsonDto, Employee, EmployeePersistable>{

	private static EmployeeMappers employeeMappers=new EmployeeMappers();

	public static EmployeeMappers getEmployeeMappers() {
		return employeeMappers;
	}
	
	public EmployeeJsonDto  mapPersistableToJsonDto(EmployeePersistable persistable) {
		EmployeeJsonDto jsonDto=new EmployeeJsonDto();

		jsonDto.setEmpId(persistable.getEmpId());
		jsonDto.setFirstName(persistable.getFirstName());
		jsonDto.setLastName(persistable.getLastName());
		jsonDto.setMobileNumber(persistable.getMobileNumber());
		jsonDto.setAddress(persistable.getAddress());
		jsonDto.setPincode(persistable.getPincode());
		jsonDto.setUsername(persistable.getUsername());
		return jsonDto;
		
	}
	
	public EmployeePersistable  mapSignUpRequestToPersistable(EmployeeSignUpRequest request) {
	
		EmployeePersistable persistable=new EmployeePersistable();
		persistable.setFirstName(request.getFirstName());
		persistable.setLastName(request.getLastName());
		persistable.setMobileNumber(request.getMobileNumber());
		persistable.setPassword(request.getPassword());
		persistable.setAddress(request.getAddress());
		persistable.setPincode(request.getPincode());
		persistable.setCreatedBy("USER");
		persistable.setCreatedOn(DateTimeUtil.getCurrentDate());
		persistable.setRecordStatus("Active");
		return persistable;
	
	}
}
