package com.snehal.carservice.model.domain;

import com.snehal.carservice.common.util.StringSetConverter;
import com.snehal.carservice.model.dto.BookingJsonDto;
import com.snehal.carservice.model.dto.UserVehicleDetailJsonDto;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Convert;
import javax.validation.constraints.NotBlank;

public class AppUser implements IDomain {

  private @NotBlank Long userId;
  private @NotBlank String username;
  private @NotBlank String password;
  private @NotBlank String passwordConfirm;
  private @NotBlank String email;
  private @NotBlank String mobileNumber;
  private @NotBlank String firstName;
  private @NotBlank String lastName;
  private Date dateOfBirth;
  private @NotBlank boolean loggedIn;

  @Convert(converter = StringSetConverter.class)
  private Set<UserVehicleDetailJsonDto> vehicleDetails = new HashSet<UserVehicleDetailJsonDto>();

  private Set<BookingJsonDto> bookings = new HashSet<BookingJsonDto>();

  public AppUser() {
    super();
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  public Set<UserVehicleDetailJsonDto> getVehicleDetails() {
    return vehicleDetails;
  }

  public void setVehicleDetails(Set<UserVehicleDetailJsonDto> vehicleDetails) {
    this.vehicleDetails = vehicleDetails;
  }

  public Set<BookingJsonDto> getBookings() {
    return bookings;
  }

  public void setBookings(Set<BookingJsonDto> bookings) {
    this.bookings = bookings;
  }
}
