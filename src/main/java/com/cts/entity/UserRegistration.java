package com.cts.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

//import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity(name="user")
@ApiModel(description = "This is the customer model")
public class UserRegistration {
	
	
	@ApiModelProperty(value="Login Id of a user")
	@Id
	public String username;
	
	@ApiModelProperty(value= "EmailId of a user")
	@NotBlank
	public String email;
	
	@ApiModelProperty(value= "Firstname of a user")
	@NotBlank
	private String firstName;
	
	@ApiModelProperty(value= "Lastname of a user")
	private String lastName;
	
	@ApiModelProperty(value= "password of a user")
	@NotBlank
	private String password;
	
	@ApiModelProperty(value= "confirmpassword of a user")
	@NotBlank
	private String confirmPassword;
	
	@ApiModelProperty(value= "Contact Number of a user")
	@NotBlank
	private String contactNumber;
	
	@JsonIgnore
	private String role;
	
	public UserRegistration() {
		super();
	}

	
	public UserRegistration(@NotBlank String username, @NotBlank String email, @NotBlank String firstName,
			String lastName, @NotBlank String password, @NotBlank String confirmPassword,
			@NotBlank String contactNumber) {
		super();
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.contactNumber = contactNumber;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role=role;
		
	}
}
