package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

	private String email;
	
	private String name;
	
	private String family;
	
	private String city;
	
	private String address;
	
	private String postalCode;
	
	private String phoneNumber;
	
	public Customer(){}

	public Customer(String email, String name, String family, String city, String address, String postalCode,
			String phoneNumber) {
		super();
		this.email = email;
		this.name = name;
		this.family = family;
		this.city = city;
		this.address = address;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", name=" + name + ", family=" + family + ", city=" + city + ", address="
				+ address + ", postalCode=" + postalCode + ", phoneNumber=" + phoneNumber + "]";
	}


}
