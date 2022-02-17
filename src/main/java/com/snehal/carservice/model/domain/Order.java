package com.snehal.carservice.model.domain;

import javax.validation.constraints.NotBlank;

public class Order {

  private Long orderId;

  private Booking booking;

  private String orderStatus;

  // This relationship will become one to one if need to restrict one order for one user detail
  // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

  private @NotBlank UserVehicleDetail userVehicleDetail;

  private Product product;

  public Order() {
    super();
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Booking getBooking() {
    return booking;
  }

  public void setBooking(Booking booking) {
    this.booking = booking;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
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
