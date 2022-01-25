package com.snehal.carservice.mapper;

import com.snehal.carservice.model.domain.Assignment;
import com.snehal.carservice.model.dto.AssignmentJsonDto;
import com.snehal.carservice.model.dto.UserVehicleDetailJsonDto;
import com.snehal.carservice.model.persistable.AssignmentPersistable;
import com.snehal.carservice.model.persistable.UserVehicleDetailPersistable;

public class AssignmentMappers extends AbstarctMapper<AssignmentJsonDto, Assignment, AssignmentPersistable>{

	
	private static AssignmentMappers assignmentMappers=new AssignmentMappers();

	public static AssignmentMappers getAssignmentMappers() {
		return assignmentMappers;
	
	}
	
	public AssignmentJsonDto  mapPersistableToJsonDto(AssignmentPersistable persistable) {
		
		AssignmentJsonDto jsonDto= modelMapper.map(persistable, AssignmentJsonDto.class);
		return jsonDto;
		
	}
	
}
