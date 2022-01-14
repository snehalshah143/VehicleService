package com.snehal.carservice.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.snehal.carservice.util.StringSetConverter;
@Entity
@Table(name = "booking")
public class Booking implements Serializable{
	
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="booking_sequence_generator")
	@SequenceGenerator(name="booking_sequence_generator" ,sequenceName = "booking_seq")
    private Long bookingId;
    
	//TODO initalize product cart with hash set
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("booking")
    @Convert(converter = StringSetConverter.class)
    private @NotBlank Set<Order> productCart=new HashSet<Order>();
	
    private @NotBlank Double finalAmount;
      
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    @JsonIgnoreProperties("bookings")
    private AppUser appUser;
   
public Booking(){
    	
    }
	public Booking(@NotBlank Set<Order> productCart, @NotBlank Double finalAmount) {
	super();
	this.productCart = productCart;
	this.finalAmount = finalAmount;
}

	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Set<Order> getProductCart() {
		return productCart;
	}
	public void setProductCart(Set<Order> productCart) {
		this.productCart = productCart;
	}
	
	public Double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}
	public AppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

    
}
