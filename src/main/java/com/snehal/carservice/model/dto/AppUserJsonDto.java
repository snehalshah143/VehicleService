package com.snehal.carservice.model.dto;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@JsonInclude(Include.NON_NULL)
public class AppUserJsonDto implements IJsonDto {

	    private @NotBlank Long userId;
	    private @NotBlank String username;
	    private @NotBlank String password;
	    private @NotBlank String passwordConfirm;
	    private @NotBlank String email;
	    private @NotBlank String mobileNumber;
	    private @NotBlank String firstName;
	    private @NotBlank String lastName;
	    private Date dateOfBirth;
//	    private @NotBlank boolean loggedIn;
	    

	    private String vehicleDetails;
	    private String bookings;
		public AppUserJsonDto() {
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


		public Set<UserVehicleDetailJsonDto> getVehicleDetails() {
			
			ObjectMapper mapper = new ObjectMapper();
			Set<UserVehicleDetailJsonDto> vehicleDetailsSet = null;
			if(vehicleDetails!=null) {
			try {
				vehicleDetailsSet=mapper.readValue(vehicleDetails, new TypeReference<Set<UserVehicleDetailJsonDto>>() {});
		
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


			
			return vehicleDetailsSet;
		}

		public void setVehicleDetails(Set<UserVehicleDetailJsonDto> vehicleDetailsJsonDtoSet) {
			ObjectMapper mapper = new ObjectMapper();
			if(vehicleDetailsJsonDtoSet!=null) {
			try {
				this.vehicleDetails = mapper.writeValueAsString(vehicleDetailsJsonDtoSet);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			}

		public Set<BookingJsonDto> getBookings() {
			
			ObjectMapper mapper = new ObjectMapper();
			Set<BookingJsonDto> bookingJsonDtoSet = null;
			if(bookings!=null) {
			try {
				bookingJsonDtoSet=mapper.readValue(bookings, new TypeReference<Set<BookingJsonDto>>() {});
		
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


			
			return bookingJsonDtoSet;


		}

		public void setBookings(Set<BookingJsonDto> bookingsJsonDtoSet) {
			
			ObjectMapper mapper = new ObjectMapper();
			if(bookingsJsonDtoSet!=null) {
			try {
				this.bookings = mapper.writeValueAsString(bookingsJsonDtoSet);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	    
	    
}
