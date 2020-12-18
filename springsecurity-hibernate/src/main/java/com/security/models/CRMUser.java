package com.security.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CRMUser {
	
	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	private String userName;
	
	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	private String password;
	
	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	private String matchingPassword;
	
	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	private String firstName;
	
	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	private String lastName;
	
	@NotNull(message = "Is Required")
	@Size(min = 1, message = "Is Required")
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
