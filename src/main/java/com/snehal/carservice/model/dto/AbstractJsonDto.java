package com.snehal.carservice.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public abstract class AbstractJsonDto implements Serializable{

    private @NotBlank String updatedOn;
    private @NotBlank String updatedBy;
    private @NotBlank String recordStatus;
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
    
    
}
