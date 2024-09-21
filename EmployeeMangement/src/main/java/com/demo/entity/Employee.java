package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eid;

	private String firstName;

	private String lastName;
	@Column(nullable = false, unique = true)
	private String email;

	public Employee(Long eid, String firstName, String lastName, String email) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Employee() {
		super();
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
		return "Employee [eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

}
