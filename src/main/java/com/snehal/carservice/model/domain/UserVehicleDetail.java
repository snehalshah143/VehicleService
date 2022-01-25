package com.snehal.carservice.model.domain;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.snehal.carservice.common.VehicleSegment;


public class UserVehicleDetail {

    private Long detailId;
    private @NotBlank String countryCode="+91";
    private @NotBlank String address;
    private @NotBlank String society;
    private @NotBlank String locality;
    private @NotBlank String zone;
    private @NotBlank String parkingPlace;
    private @NotBlank String pincode;
    private @NotBlank String vehicleNumber;
    private @NotBlank String manufacturingCompanyAndModel;
    private @NotBlank VehicleSegment vehicleSegment;
    

    private AppUser appUser;


	public UserVehicleDetail() {
		super();
	}


	public Long getDetailId() {
		return detailId;
	}


	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSociety() {
		return society;
	}


	public void setSociety(String society) {
		this.society = society;
	}


	public String getLocality() {
		return locality;
	}


	public void setLocality(String locality) {
		this.locality = locality;
	}


	public String getZone() {
		return zone;
	}


	public void setZone(String zone) {
		this.zone = zone;
	}


	public String getParkingPlace() {
		return parkingPlace;
	}


	public void setParkingPlace(String parkingPlace) {
		this.parkingPlace = parkingPlace;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getManufacturingCompanyAndModel() {
		return manufacturingCompanyAndModel;
	}


	public void setManufacturingCompanyAndModel(String manufacturingCompanyAndModel) {
		this.manufacturingCompanyAndModel = manufacturingCompanyAndModel;
	}


	public VehicleSegment getVehicleSegment() {
		return vehicleSegment;
	}


	public void setVehicleSegment(VehicleSegment vehicleSegment) {
		this.vehicleSegment = vehicleSegment;
	}


	public AppUser getAppUser() {
		return appUser;
	}


	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
    
    
  


    
}
