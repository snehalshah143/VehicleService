package com.snehal.carservice.model.persistable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class EmployeePersistable extends AbstractPerstistable{
	
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="employee_sequence_generator")
	@SequenceGenerator(name="employee_sequence_generator" ,sequenceName = "employee_seq")
    private Long empId;
    private String username;
    private @NotBlank String password;
    private @NotBlank String email;
    private @NotBlank String mobileNumber;
    private @NotBlank String firstName;
    private @NotBlank String lastName;
    private @NotBlank String address;
    private @NotBlank boolean loggedIn;

}
