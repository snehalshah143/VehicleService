package com.snehal.carservice.model.dto;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snehal.carservice.model.persistable.PaymentPersistable;

public class BookingJsonDto implements Serializable{
	
    private Long bookingId;
    

//    @Convert(converter = StringSetConverter.class)
    private @NotBlank String productCart;
	
    private @NotBlank Double finalAmount;

    private String paymentStatus;
    private String appUser;

	public BookingJsonDto() {
		super();
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Set<OrderJsonDto> getProductCart() {
		
		ObjectMapper mapper = new ObjectMapper();
		Set<OrderJsonDto> orderJsonDtoSet = null;
		if(productCart!=null) {
		try {
			orderJsonDtoSet=mapper.readValue(productCart, new TypeReference<Set<OrderJsonDto>>() {});
	
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
		return orderJsonDtoSet;

	}

	public void setProductCart(Set<OrderJsonDto> productCartSet) {
		ObjectMapper mapper = new ObjectMapper();
		if(productCartSet!=null) {
		try {
			this.productCart = mapper.writeValueAsString(productCartSet);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
			}

	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
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
		} catch (IOException e) {
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

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
   
    
}
