package com.snehal.carservice.model.dto;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@JsonInclude(Include.NON_NULL)
public class AssignmentJsonDto extends AbstractJsonDto{

	private Long assignmentId;
	
	private Date assignmentDate;
	
	private Integer priority;
	
	private String assignmentStatus;
	
	private Date assignmentStartTime;
	private Date assignmentEndTime;
	//This can be also the filename ofimage for less 
	private byte[] imageBefore;
	private byte[] imageAfter;


//    private OrderJsonDto order;
    private String order;


	public AssignmentJsonDto() {
		super();
	}


	public Long getAssignmentId() {
		return assignmentId;
	}


	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}


	public Date getAssignmentDate() {
		return assignmentDate;
	}


	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public String getAssignmentStatus() {
		return assignmentStatus;
	}


	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}


	public Date getAssignmentStartTime() {
		return assignmentStartTime;
	}


	public void setAssignmentStartTime(Date assignmentStartTime) {
		this.assignmentStartTime = assignmentStartTime;
	}


	public Date getAssignmentEndTime() {
		return assignmentEndTime;
	}


	public void setAssignmentEndTime(Date assignmentEndTime) {
		this.assignmentEndTime = assignmentEndTime;
	}


	public byte[] getImageBefore() {
		return imageBefore;
	}


	public void setImageBefore(byte[] imageBefore) {
		this.imageBefore = imageBefore;
	}


	public byte[] getImageAfter() {
		return imageAfter;
	}


	public void setImageAfter(byte[] imageAfter) {
		this.imageAfter = imageAfter;
	}


	public OrderJsonDto getOrder() {
		
		ObjectMapper mapper = new ObjectMapper();
		OrderJsonDto orderJsonDto = null;
		if(order!=null) {
		try {
			orderJsonDto = mapper.readValue(order, OrderJsonDto.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return orderJsonDto;
	}


	public void setOrder(OrderJsonDto orderJsonDto) {
		
		ObjectMapper mapper = new ObjectMapper();
		if(orderJsonDto!=null) {
		try {
			this.order = mapper.writeValueAsString(orderJsonDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}


}
