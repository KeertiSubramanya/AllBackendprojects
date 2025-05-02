package com.dronezzfly.requestdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {
		@NotNull(message="firstname is required")
		@Size(min=6, max=10, message="firstname must contain 6 to 10 characters")
	 	private String firstName;
		
		@NotNull(message="lastname is required")
	    private String lastName;
	    
	    @Email(message="invalid mail")
	    @NotNull(message="email is required")
	    private String mailId;
	    private Long mobilenumber;
	    private String gender;
	    private String dob;
	    private String password;


}
