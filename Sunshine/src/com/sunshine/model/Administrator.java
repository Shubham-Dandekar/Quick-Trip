package com.sunshine.model;

public class Administrator {
	private int adminID;
	private String firstName;
	private String fatherName;
	private String lastName;
	private String motherName;
	private String dateOfBirth;
	private String gender;
	private String address;
	private String contactNo;
	private String email;
	private String password;
	
	public Administrator() {
		super();
	}

	public Administrator(int adminID, String firstName, String fatherName, String lastName, String motherName,
			String dateOfBirth, String gender, String address, String contactNo, String email, String password) {
		super();
		this.adminID = adminID;
		this.firstName = firstName;
		this.fatherName = fatherName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
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
		return "Administrator [adminID=" + adminID + ", firstName=" + firstName + ", fatherName=" + fatherName
				+ ", lastName=" + lastName + ", motherName=" + motherName + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", address=" + address + ", contactNo=" + contactNo + ", email=" + email + ", password="
				+ password + "]";
	}
}
