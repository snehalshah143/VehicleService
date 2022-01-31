package com.snehal.carservice.model.persistable;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "appuser")
public class AppUserPersistable implements Serializable{
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="user_sequence_generator")
	@SequenceGenerator(name="user_sequence_generator" ,sequenceName = "uder_seq")
    private Long userId;
    private String username;
    private @NotBlank String password;
    private @NotBlank String email;
    private @NotBlank String mobileNumber;
    private @NotBlank String firstName;
    private @NotBlank String lastName;
    private @NotBlank boolean loggedIn;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("appuser")
//    private Set <UserVehicleDetailPersistable> vehicleDetails = new HashSet<UserVehicleDetailPersistable>();
    private Set <UserVehicleDetailPersistable> vehicleDetails ;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("appuser")
//    private Set <BookingPersistable> bookings = new HashSet<BookingPersistable>();
    private Set <BookingPersistable> bookings;

	public AppUserPersistable(){
    	
    }


    
    public AppUserPersistable(String mobileNumber,String password, String email, 
		String firstName, String lastName) {
	super();

	this.username = "USER"+mobileNumber;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.firstName = firstName;
	this.lastName = lastName;
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
    @Transient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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



	public Set<UserVehicleDetailPersistable> getVehicleDetails() {
		return vehicleDetails;
	}



	public void setVehicleDetails(Set<UserVehicleDetailPersistable> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}



	public Set<BookingPersistable> getBookings() {
		return bookings;
	}
	public void setBookings(Set<BookingPersistable> bookings) {
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
