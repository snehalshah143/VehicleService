package com.snehal.carservice.model.domain;

import java.util.Date;

public class Assignment {

  private Long assignmentId;

  private Date assignmentDate;

  private Integer priority;

  private String assignmentStatus;

  private Date assignmentStartTime;
  private Date assignmentEndTime;
  // This can be also the filename ofimage for less
  private byte[] imageBefore;
  private byte[] imageAfter;

  private Order order;

  public Assignment() {
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

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}
