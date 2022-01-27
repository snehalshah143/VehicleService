package com.snehal.carservice.model.dto;


import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snehal.carservice.common.VehicleSegment;
@JsonInclude(Include.NON_NULL)
public class UserVehicleDetailJsonDto implements Serializable{
 
    private Long detailId;
    private @NotBlank String address;
    private @NotBlank String society;
    private @NotBlank String locality;
    private @NotBlank String parkingPlace;
    private @NotBlank String pincode;
    private @NotBlank String vehicleNumber;
    private @NotBlank String manufacturingCompanyAndModel;
    private @NotBlank VehicleJsonDto vehicle;
    
    private String appUser;

	public UserVehicleDetailJsonDto() {
		super();
	}

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
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

	
	
	public VehicleJsonDto getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleJsonDto vehicle) {
		this.vehicle = vehicle;
	}

	public AppUserJsonDto getAppUser() {
		ObjectMapper mapper = new ObjectMapper();
		AppUserJsonDto appUserJsonDto = null;
		if(appUser!=null) {
		try {
			appUserJsonDto = mapper.readValue(appUser, AppUserJsonDto.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return appUserJsonDto;
	}

	public void setAppUser(AppUserJsonDto appUserJsonDto) {
		ObjectMapper mapper = new ObjectMapper();
		if(appUserJsonDto!=null) {
		try {
			this.appUser = mapper.writeValueAsString(appUserJsonDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
    
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
 
    
}
