package com.example.DemoGraphQL.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
	@Id
	@Column(name = "appointment_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "starts_at")
	private String startsAt;

	@Column(name = "stylist")
	private String stylist;

	@Column(name = "service")
	private String service;

	@Column(name = "notes")
	private String notes;

	public Long getId() {
		return id;
	}

	public Appointment(String startsAt, String stylist, String service, String notes) {
		super();
		this.startsAt = startsAt;
		this.stylist = stylist;
		this.service = service;
		this.notes = notes;
	}
	
	public Appointment() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(String startsAt) {
		this.startsAt = startsAt;
	}

	public String getStylist() {
		return stylist;
	}

	public void setStylist(String stylist) {
		this.stylist = stylist;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
