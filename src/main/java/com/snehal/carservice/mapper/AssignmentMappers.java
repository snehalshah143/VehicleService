package com.snehal.carservice.mapper;

import com.snehal.carservice.model.domain.Assignment;
import com.snehal.carservice.model.dto.AssignmentJsonDto;
import com.snehal.carservice.model.dto.OrderJsonDto;
import com.snehal.carservice.model.persistable.AssignmentPersistable;

public class AssignmentMappers
    extends AbstarctMapper<AssignmentJsonDto, Assignment, AssignmentPersistable> {

  private static AssignmentMappers assignmentMappers = new AssignmentMappers();

  public static AssignmentMappers getAssignmentMappers() {
    return assignmentMappers;
  }

  public AssignmentJsonDto mapPersistableToJsonDto(AssignmentPersistable persistable) {
    AssignmentJsonDto jsonDto = new AssignmentJsonDto();
    jsonDto.setAssignmentId(persistable.getAssignmentId());
    jsonDto.setAssignmentDate(persistable.getAssignmentDate());
    jsonDto.setAssignmentEndTime(persistable.getAssignmentEndTime());
    jsonDto.setAssignmentStartTime(persistable.getAssignmentStartTime());
    jsonDto.setAssignmentStatus(persistable.getAssignmentStatus());
    jsonDto.setImageAfter(persistable.getImageAfter());

    jsonDto.setImageBefore(persistable.getImageBefore());
    OrderJsonDto orderJsonDto = new OrderJsonDto();
    orderJsonDto.setOrderId(persistable.getOrder().getOrderId());
    jsonDto.setOrder(orderJsonDto);
    jsonDto.setPriority(persistable.getPriority());

    //		AssignmentJsonDto jsonDto= modelMapper.map(persistable, AssignmentJsonDto.class);
    return jsonDto;
  }
}
