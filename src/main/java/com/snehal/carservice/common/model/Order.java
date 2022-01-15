package com.snehal.carservice.common.model;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
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
@Table(name = "product_order")
public class Order implements Serializable {

	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="order_sequence_generator")
	@SequenceGenerator(name="order_sequence_generator" ,sequenceName = "order_seq")
	private Long orderId;
//new	
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id", referencedColumnName = "bookingId")
    @JsonIgnoreProperties("productCart")
    private Booking booking;
    
    
//new
	
    public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	
	//This relationship will become one to one if need to restrict one order for one user detail
	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name = "detail_id", referencedColumnName = "detailId")
//  @JsonIgnoreProperties("order")
    private @NotBlank UserVehicleDetail userVehicleDetail;
    
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product;

    public Order(){
    }
    
	public Order(Product product, UserVehicleDetail userVehicleDetail) {
		super();
		this.product = product;
		this.userVehicleDetail = userVehicleDetail;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public UserVehicleDetail getUserVehicleDetail() {
		return userVehicleDetail;
	}
	public void setUserVehicleDetail(UserVehicleDetail userVehicleDetail) {
		this.userVehicleDetail = userVehicleDetail;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
   
}
