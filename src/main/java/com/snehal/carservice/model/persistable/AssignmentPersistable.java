package com.snehal.carservice.model.persistable;

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
@Entity
@Table(name = "assignment")
public class AssignmentPersistable extends AbstractPerstistable{
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
    @JoinColumn(name = "emp_id", referencedColumnName = "empId")
    private EmployeePersistable employee;
	
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private OrderPersistable order;
	

	public AssignmentPersistable( Date assignmentDate, Integer priority,
			String assignmentStatus, OrderPersistable order) {
		super();
	
		this.assignmentDate = assignmentDate;
		this.priority = priority;
		this.assignmentStatus = assignmentStatus;
		this.order = order;
	}
	public AssignmentPersistable() {
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
	public OrderPersistable getOrder() {
		return order;
	}
	public void setOrder(OrderPersistable order) {
		this.order = order;
	}
	
   
}
