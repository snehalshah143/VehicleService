package com.snehal.carservice.model.persistable;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import com.snehal.carservice.common.util.StringSetConverter;
@Entity
@Table(name = "booking")
public class BookingPersistable extends AbstractPerstistable{
	
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="booking_sequence_generator")
	@SequenceGenerator(name="booking_sequence_generator" ,sequenceName = "booking_seq")
    private Long bookingId;
    
	//TODO initalize product cart with hash set
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("booking")
    private @NotBlank Set<OrderPersistable> productCart;
    private @NotBlank Double finalAmount;
      
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    @JsonIgnoreProperties("bookings")
    private AppUserPersistable appUser;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("booking")
    private List<PaymentPersistable> payments ;
    
    
    private String paymentStatus;
   
public BookingPersistable(){
    	
    }
	public BookingPersistable(@NotBlank Set<OrderPersistable> productCart, @NotBlank Double finalAmount) {
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
	public Set<OrderPersistable> getProductCart() {
		return productCart;
	}
	public void setProductCart(Set<OrderPersistable> productCart) {
		this.productCart = productCart;
	}
	
	public Double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}
	public AppUserPersistable getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUserPersistable appUser) {
		this.appUser = appUser;
	}
	public List<PaymentPersistable> getPayments() {
		return payments;
	}
	public void setPayments(List<PaymentPersistable> payments) {
		this.payments = payments;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	
    
}
