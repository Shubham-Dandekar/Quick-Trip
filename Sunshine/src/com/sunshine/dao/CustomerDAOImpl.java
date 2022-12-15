package com.sunshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.sunshine.exception.CustomerException;
import com.sunshine.model.Address;
import com.sunshine.model.Customer;
import com.sunshine.model.CustomerDTO3;
import com.sunshine.utility.DBUtil;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public int customerLogIn(String email, String password) throws CustomerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCustomerFirstName(int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer showCustomerDetails(int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerNewCustomer(Customer customer) throws CustomerException {
		String msg = "Failed to register new customer...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into administrator values(?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, customer.getAdminID());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getFatherName());
			ps.setString(4, customer.getLastName());
			ps.setString(5, customer.getMotherName());
			ps.setString(6, customer.getDateOfBirth());
			ps.setString(7, customer.getGender());
			ps.setString(8, customer.getAddressID());
			ps.setInt(9, customer.getContactNo());
			ps.setString(10, customer.getEmail());
			ps.setString(11, customer.getPassword());
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = customer.getFirstName() + " " + customer.getLastName() + " registered as customer successfully...";
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeCustomerFirstName(String firstName, int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCustomerLastName(String lastName, int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCustomerFatherName(String fatherName, int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCustomerMotherName(String motherName, int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCustomerGender(String gender, int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCustomerDateOfBirth(String dateOfBirth, int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCustomerAddress(Address address, int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCustomerContactNo(String contactNo, int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCustomerEmail(String email, int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomerPassword(int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCustomerPassword(String password, int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO3> showAllCustomers() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
