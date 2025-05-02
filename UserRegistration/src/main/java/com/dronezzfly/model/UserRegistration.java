package com.dronezzfly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
    private String lastName;
    private String mailId;
    private Long mobilenumber;
    private String gender;
    private String dob; // Use LocalDate for better date handling
    private String password;
    private String status;
}


