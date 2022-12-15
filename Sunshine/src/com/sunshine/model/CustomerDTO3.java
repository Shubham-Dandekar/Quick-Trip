package com.sunshine.model;

import java.time.LocalDate;

public class CustomerDTO3 {
	private String customerID;
	private String firstname;
	private String fatherName;
	private String lastName;
	private String motherName;
	private LocalDate dateOfBirth;
	private String gender;
	private String addressID;
	private int contactNo;
	private String email;
	
	public CustomerDTO3() {
		super();
	}

	public CustomerDTO3(String customerID, String firstname, String fatherName, String lastName, String motherName,
			LocalDate dateOfBirth, String gender, String addressID, int contactNo, String email) {
		super();
		this.customerID = customerID;
		this.firstname = firstname;
		this.fatherName = fatherName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.addressID = addressID;
		this.contactNo = contactNo;
		this.email = email;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
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

	@Override
	public String toString() {
		return "CustomerDTO3 [customerID=" + customerID + ", firstname=" + firstname + ", fatherName=" + fatherName
				+ ", lastName=" + lastName + ", motherName=" + motherName + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", addressID=" + addressID + ", contactNo=" + contactNo + ", email=" + email + "]";
	}
}
