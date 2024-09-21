package com.demo.dto;

import jakarta.persistence.Column;

public class EmployeeDto {
	
	private Long eid;

	private String firstName;

	private String lastName;
	
	private String email;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(Long eid, String firstName, String lastName, String email) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
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

	@Override
	public String toString() {
		return "EmployeeDto [eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
}
