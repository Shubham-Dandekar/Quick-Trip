package com.sunshine.dao;

import com.sunshine.exception.AdministratorException;
import com.sunshine.model.Administrator;

public interface AdministratorDAO {
//	LogIn, registration and show details
	
	public int adminLogIn(String email, String password) throws AdministratorException;
	
	public String getAdminName(int adminID) throws AdministratorException;
	
	public Administrator showAdminDetails(int adminID) throws AdministratorException;
	
	public String registerNewAdmin(Administrator admin) throws AdministratorException;
	
//	Update profile details
	
	public String changeAdminFirstName(String firstName, int adminID) throws AdministratorException;

	public String changeAdminLastName(String lastName, int adminID) throws AdministratorException;
	
	public String changeAdminFatherName(String fatherName, int adminID) throws AdministratorException;
	
	public String changeAdminMotherName(String motherName, int adminID) throws AdministratorException;
	
	public String changeAdminGender(String gender, int adminID) throws AdministratorException;
	
	public String changeAdminDateOfBirth(String dateOfBirth, int adminID) throws AdministratorException;
	
	public String changeAdminAddress(String address, int adminID) throws AdministratorException;
	
	public String changeAdminContactNo(String contactNo, int adminID) throws AdministratorException;
	
	public String changeAdminEmail(String email, int adminID) throws AdministratorException;
	
//	Show and change password
	
	public String getAdminPassword(int adminID) throws AdministratorException;
	
	public String changeAdminPassword(String password, int adminID) throws AdministratorException;
}
