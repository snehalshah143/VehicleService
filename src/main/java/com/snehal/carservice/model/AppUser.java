package com.snehal.carservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "appuser")
public class AppUser implements Serializable{
    private @Id  @GeneratedValue(strategy = GenerationType.TABLE) Long userId;
    private @NotBlank String username;
    private @NotBlank String password;
    private @NotBlank String passwordConfirm;
    private @NotBlank String email;
    private @NotBlank String mobileNumber;
    private @NotBlank String firstName;
    private @NotBlank String lastName;
    private @NotBlank Date dateOfBirth;
    private @NotBlank boolean loggedIn;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("appuser")
    private Set <UserVehicleDetail> vehicleDetails = new HashSet<UserVehicleDetail>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("appuser")
    private Set <Booking> bookings = new HashSet<Booking>();
 /*
    //dummy
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("appuser")
    private Set <Order> orders = new HashSet<Order>();
      
    
    public Set<Order> getOrders() {
		return orders;
	}



	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
*/


	public AppUser(){
    	
    }


    
    public AppUser(String mobileNumber,String password, String passwordConfirm, String email, 
		String firstName, String lastName, Date dateOfBirth) {
	super();

	this.username = "USER"+mobileNumber;
	this.password = password;
	this.passwordConfirm = passwordConfirm;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.loggedIn = false;
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



	public Long getId() {
        return userId;
    }
	public void setId(Long id) {
        this.userId = id;
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

    @Transient
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

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}



	public Set<UserVehicleDetail> getVehicleDetails() {
		return vehicleDetails;
	}



	public void setVehicleDetails(Set<UserVehicleDetail> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}



	public Set<Booking> getBookings() {
		return bookings;
	}



	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	
/*    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set < Role > getRoles() {
        return roles;
    }

    public void setRoles(Set < Role > roles) {
        this.roles = roles;
    }*/
}
