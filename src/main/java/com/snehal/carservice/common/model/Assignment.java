package com.snehal.carservice.common.model;

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
@Entity
@Table(name = "assignment")
public class Assignment implements Serializable{
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="assignment_sequence_generator")
	@SequenceGenerator(name="assignment_sequence_generator" ,sequenceName = "assignment_seq")
	private Long assignmentId;
	
	private Date assignmentDate;
	
	private Integer priority;
	
	private String assignmentStatus;
	
	private Date assignmentStartTime;
	private Date assignmentEndTime;
	//This can be also the filename ofimage for less 
	private byte[] imageBefore;
	private byte[] imageAfter;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private Order order;
	

	public Assignment( Date assignmentDate, Integer priority,
			String assignmentStatus, Order order) {
		super();
	
		this.assignmentDate = assignmentDate;
		this.priority = priority;
		this.assignmentStatus = assignmentStatus;
		this.order = order;
	}
	public Assignment() {
		super();
	}
	public Long getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
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
	public Date getAssignmentDate() {
		return assignmentDate;
	}
	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
