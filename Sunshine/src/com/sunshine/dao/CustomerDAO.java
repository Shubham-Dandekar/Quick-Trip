package com.sunshine.dao;

import java.util.List;

import com.sunshine.exception.CustomerException;
import com.sunshine.model.Address;
import com.sunshine.model.Customer;
import com.sunshine.model.CustomerDTO3;

public interface CustomerDAO {

//	LogIn, registration and show details
	
	public int customerLogIn(String email, String password) throws CustomerException;
	
	public String getCustomerFirstName(int customerID) throws CustomerException;
	
	public Customer showCustomerDetails(int customerID) throws CustomerException;
	
	public String registerNewCustomer(Customer customer) throws CustomerException;
	
//	Update profile details
	
	public String changeCustomerFirstName(String firstName, int customerID) throws CustomerException;

	public String changeCustomerLastName(String lastName, int customerID) throws CustomerException;
	
	public String changeCustomerFatherName(String fatherName, int customerID) throws CustomerException;
	
	public String changeCustomerMotherName(String motherName, int customerID) throws CustomerException;
	
	public String changeCustomerGender(String gender, int customerID) throws CustomerException;
	
	public String changeCustomerDateOfBirth(String dateOfBirth, int customerID) throws CustomerException;
	
	public String changeCustomerAddress(Address address, int customerID) throws CustomerException;
	
	public String changeCustomerContactNo(String contactNo, int customerID) throws CustomerException;
	
	public String changeCustomerEmail(String email, int customerID) throws CustomerException;
	
//	Show and change password
	
	public String getCustomerPassword(int customerID) throws CustomerException;
	
	public String changeCustomerPassword(String password, int customerID) throws CustomerException;
	
//	Other
	
	public List<CustomerDTO3> showAllCustomers() throws CustomerException;
}
