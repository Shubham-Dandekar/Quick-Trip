package com.sunshine.model;

import java.time.LocalDate;

public class Customer {
	private String customerID;
	private String firstName;
	private String fatherName;
	private String lastName;
	private String motherName;
	private String dateOfBirth;
	private String gender;
	private String addressID;
	private int contactNo;
	private String email;
	private String password;
	
	public Customer() {
		super();
	}

	public Customer(String customerID, String firstName, String lastName, String dateOfBirth, String gender,
			String addressID, int contactNo, String email, String password) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.addressID = addressID;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
	}

	public Customer(String customerID, String firstName, String fatherName, String lastName, String motherName,
			String dateOfBirth, String gender, String addressID, int contactNo, String email, String password) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.fatherName = fatherName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.addressID = addressID;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
	}

	public String getAdminID() {
		return customerID;
	}

	public void setAdminID(String customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddressID() {
		return addressID;
	}

	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [customerID=" + customerID + ", firstName=" + firstName + ", fatherName=" + fatherName
				+ ", lastName=" + lastName + ", motherName=" + motherName + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", addressID=" + addressID + ", contactNo=" + contactNo + ", email=" + email + ", password="
				+ password + "]";
	}
}
