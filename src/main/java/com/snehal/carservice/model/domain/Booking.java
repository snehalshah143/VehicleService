package com.snehal.carservice.model.domain;

import com.snehal.carservice.common.util.StringSetConverter;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Convert;
import javax.validation.constraints.NotBlank;

public class Booking {

  private Long bookingId;

  @Convert(converter = StringSetConverter.class)
  private @NotBlank Set<Order> productCart = new HashSet<Order>();

  private @NotBlank Double finalAmount;

  private AppUser appUser;

  public Booking() {
    super();
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
