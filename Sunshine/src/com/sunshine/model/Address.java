package com.sunshine.model;

public class Address {
	private String addressID;
	private String city;
	private String state;
	private String country;
	
	public Address() {
		super();
	}

	public Address(String addressID, String city, String state, String country) {
		super();
		this.addressID = addressID;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getAddressID() {
		return addressID;
	}

	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
}
