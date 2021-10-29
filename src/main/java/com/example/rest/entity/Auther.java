package com.example.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Auther {
	@Id
	private int atherId;
	private String firstName;
	private String lastName;
	private String language;
	public int getAtherId() {
		return atherId;
	}
	public void setAtherId(int atherId) {
		this.atherId = atherId;
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
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	

}
