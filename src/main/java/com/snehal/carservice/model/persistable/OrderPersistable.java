package com.snehal.carservice.model.persistable;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "product_order")
public class OrderPersistable implements Serializable {

	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="order_sequence_generator")
	@SequenceGenerator(name="order_sequence_generator" ,sequenceName = "order_seq")
	private Long orderId;
//new	
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id", referencedColumnName = "bookingId")
    @JsonIgnoreProperties("productCart")
    private BookingPersistable booking;
    
    
    private String orderStatus;
    
	//This relationship will become one to one if need to restrict one order for one user detail
	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name = "detail_id", referencedColumnName = "detailId")
//  @JsonIgnoreProperties("order")
    private @NotBlank UserVehicleDetailPersistable userVehicleDetail;
    
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private ProductPersistable product;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("order")
    private @NotBlank Set<AssignmentPersistable> assignments;
    
//new
	
    public BookingPersistable getBooking() {
		return booking;
	}

	public void setBooking(BookingPersistable booking) {
		this.booking = booking;
	}

	


    public OrderPersistable(){
    }
    
	public OrderPersistable(ProductPersistable product, UserVehicleDetailPersistable userVehicleDetail) {
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
	public UserVehicleDetailPersistable getUserVehicleDetail() {
		return userVehicleDetail;
	}
	public void setUserVehicleDetail(UserVehicleDetailPersistable userVehicleDetail) {
		this.userVehicleDetail = userVehicleDetail;
	}

	public ProductPersistable getProduct() {
		return product;
	}

	public void setProduct(ProductPersistable product) {
		this.product = product;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Set<AssignmentPersistable> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<AssignmentPersistable> assignments) {
		this.assignments = assignments;
	}
   
}
