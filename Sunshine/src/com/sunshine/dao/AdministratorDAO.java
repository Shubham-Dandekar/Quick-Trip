package com.sunshine.dao;

import com.sunshine.exception.AdministratorException;
import com.sunshine.model.Address;
import com.sunshine.model.Administrator;

public interface AdministratorDAO {
//	LogIn, registration and show details
	
	public String adminLogIn(String email, String password) throws AdministratorException;
	
	public String getAdminName(String adminID) throws AdministratorException;
	
	public Administrator showAdminDetails(String adminID) throws AdministratorException;
	
	public String registerNewAdmin(Administrator admin) throws AdministratorException;
	
//	Update profile details
	
	public String changeAdminFirstName(String firstName, String adminID) throws AdministratorException;

	public String changeAdminLastName(String lastName, String adminID) throws AdministratorException;
	
	public String changeAdminFatherName(String fatherName, String adminID) throws AdministratorException;
	
	public String changeAdminMotherName(String motherName, String adminID) throws AdministratorException;
	
	public String changeAdminGender(String gender, String adminID) throws AdministratorException;
	
	public String changeAdminDateOfBirth(String dateOfBirth, String adminID) throws AdministratorException;
	
	public String changeAdminAddress(Address address, String adminID) throws AdministratorException;
	
	public String changeAdminContactNo(String contactNo, String adminID) throws AdministratorException;
	
	public String changeAdminEmail(String email, String adminID) throws AdministratorException;
	
//	Show and change password
	
	public String getAdminPassword(String adminID) throws AdministratorException;
	
	public String changeAdminPassword(String password, String adminID) throws AdministratorException;
}
