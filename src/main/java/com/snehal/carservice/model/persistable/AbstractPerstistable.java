package com.snehal.carservice.model.persistable;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

public abstract class AbstractPerstistable implements Serializable{
    private @NotBlank Date createdOn;
    private @NotBlank String createdBy;
    private @NotBlank String recordStatus;
    
    public AbstractPerstistable() {
    	
    }
    
    public AbstractPerstistable(Date createdOn,String createdBy,String recordStatus) {
	this.createdOn=createdOn;
	this.createdBy=createdBy;
	this.recordStatus=recordStatus;
    }
    public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

}
