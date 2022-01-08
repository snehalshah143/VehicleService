package com.snehal.carservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_vehicle_detail")
public class UserVehicleDetail {
    private @Id  @GeneratedValue(strategy = GenerationType.SEQUENCE) Long detailId;
    private @NotBlank String countryCode;
    private @NotBlank String address;
    private @NotBlank String society;
    private @NotBlank String locality;
    private @NotBlank String zone;
    private @NotBlank String parkingPlace;
    private @NotBlank String pincode;
    private @NotBlank String vehicleNumber;
    private @NotBlank String manufacturingCompanyAndModel;
    private VehicleSegment vehicleCategory;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    @JsonIgnoreProperties("vehicleDetails")
    private AppUser appUser;
    
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userVehicleDetail", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("userVehicleDetail")
    private Order order;
    
    public UserVehicleDetail(){
    }

    
    




	public UserVehicleDetail(@NotBlank String address, @NotBlank String society, @NotBlank String locality,
			@NotBlank String parkingPlace, @NotBlank String pincode, @NotBlank String vehicleNumber,
			@NotBlank String manufacturingCompanyAndModel, VehicleSegment vehicleCategory) {
		super();
		this.address = address;
		this.society = society;
		this.locality = locality;
		this.parkingPlace = parkingPlace;
		this.pincode = pincode;
		this.vehicleNumber = vehicleNumber;
		this.manufacturingCompanyAndModel = manufacturingCompanyAndModel;
		this.vehicleCategory = vehicleCategory;
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



	public VehicleSegment getVehicleCategory() {
		return vehicleCategory;
	}



	public void setVehicleCategory(VehicleSegment vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}




    
}
