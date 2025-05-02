package com.dronezzfly.responsedto;

import lombok.Data;

@Data
public class UserResponseDTO {
		private Long id;
	    private String firstName;
	    private String lastName;
	    private String mailId;
	    private Long mobilenumber;
	    private String gender;
	    private String dob;
	    private String password;
	    private String status; // Set "active" or "deactive"
	    private String companyname; // Value from `company.name`
	}



