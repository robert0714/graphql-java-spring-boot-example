package com.example.DemoGraphQL.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@Column(name = "customer_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "customer_first_name", nullable = false)
	private String firstName;

	@Column(name = "customer_last_name", nullable = false)
	private String lastName;

	@Column(name = "customer_phone_number", nullable = false)
	private String phoneNumber;

	private Appointment[] appointments;

	public Customer() {
		super();

	}

	public Customer(String firstName, String lastName, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Appointment[] getAppointments() {
		return appointments;
	}

	public void setAppointments(Appointment[] appointments) {
		this.appointments = appointments;
	}

}
