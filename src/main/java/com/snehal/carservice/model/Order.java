package com.snehal.carservice.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "product_order")
public class Order {

	private @Id  @GeneratedValue(strategy = GenerationType.SEQUENCE) Long orderId;
	

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id", referencedColumnName = "detailId")
//  @JsonIgnoreProperties("order")
    private @NotBlank UserVehicleDetail userVehicleDetail;
    
    //working
/*    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("order")
    private Product product ;*/
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
