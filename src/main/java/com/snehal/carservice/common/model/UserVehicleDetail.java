package com.snehal.carservice.common.model;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_vehicle_detail")
public class UserVehicleDetail implements Serializable{
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vehicle_details_sequence_generator")
	@SequenceGenerator(name="vehicle_details_sequence_generator" ,sequenceName = "vehicle_details_seq") 
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
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    @JsonIgnoreProperties("vehicleDetails")
    private AppUser appUser;
    
 //This case if i want to restrcit one order per user details   
 //   @OneToOne(fetch = FetchType.LAZY, mappedBy = "userVehicleDetail", cascade = CascadeType.ALL)
 //   @JsonIgnoreProperties("userVehicleDetail")
 //   private Order order;
    
    /*	
	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}
*/
    
    public UserVehicleDetail(){
    }

	public UserVehicleDetail(@NotBlank String address, @NotBlank String society, @NotBlank String locality,
			@NotBlank String parkingPlace, @NotBlank String pincode, @NotBlank String vehicleNumber,
			@NotBlank String manufacturingCompanyAndModel, VehicleSegment vehicleSegment) {
		super();
		this.address = address;
		this.society = society;
		this.locality = locality;
		this.parkingPlace = parkingPlace;
		this.pincode = pincode;
		this.vehicleNumber = vehicleNumber;
		this.manufacturingCompanyAndModel = manufacturingCompanyAndModel;
		this.vehicleSegment = vehicleSegment;
	}







	public Long getId() {
        return detailId;
    }

    public void setId(Long id) {
    	this.detailId=id;
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



	public AppUser getAppUser() {
		return appUser;
	}



	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}


	public VehicleSegment getVehicleSegment() {
		return vehicleSegment;
	}

	public void setVehicleSegment(VehicleSegment vehicleSegment) {
		this.vehicleSegment = vehicleSegment;
	}





    
}
