package com.sunshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunshine.exception.CustomerException;
import com.sunshine.model.Customer;
import com.sunshine.utility.DBUtil;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public int customerLogIn(String email, String password) throws CustomerException {
		int custID = 0;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select CustomerID from customer where "
					+ "Email = ? AND Password = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				custID = rs.getInt("CustomerID");
			} else {
				throw new CustomerException("Bad credentials...");
			}
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return custID;
	}

	@Override
	public String getCustomerFirstName(int customerID) throws CustomerException {
		String msg = "No customer exists with admin ID: " + customerID;;
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select First_Name, Last_Name from "
					+ "customer where AdminID = ?");
			
			ps.setInt(1, customerID);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				String firstName = rs.getString("First_Name");
				String lastName = rs.getString("Lsst_Name");
				msg = firstName + " " + lastName;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public Customer showCustomerDetails(int customerID) throws CustomerException {
		Customer customer = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select First_Name, Last_Name, Father_Name, "
					+ "Mother_Name, Gender, Date_Of_Birth, Address, Contact_No, Email from customer "
					+ "where customerID=?");
			
			ps.setInt(1, customerID);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				customer = new Customer();
				
				customer.setCustomerID(customerID);
				customer.setFirstName(rs.getString("First_Name"));
				customer.setLastName(rs.getString("Last_Name"));
				customer.setFatherName(rs.getString("Father_Name"));
				customer.setMotherName(rs.getString("Mother_Name"));
				customer.setGender(rs.getString("Gender"));
				customer.setDateOfBirth(rs.getString("Date_Of_Birth"));
				customer.setAddress(rs.getString("Address"));
				customer.setContactNo(rs.getString("Contact_No"));
				customer.setEmail(rs.getString("Email"));
			} else {
				throw new CustomerException("Customer not found");
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		return customer;
	}

	@Override
	public String registerNewCustomer(Customer customer) throws CustomerException {
		String msg = "Failed to register new customer...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into customer (First_Name, "
					+ "Father_Name, Last_Name, Mother_Name, Date_Of_Birth, Gender, Address, "
					+ "Contact_No, Email, Password) values (?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getFatherName());
			ps.setString(3, customer.getLastName());
			ps.setString(4, customer.getMotherName());
			ps.setString(5, customer.getDateOfBirth());
			ps.setString(6, customer.getGender());
			ps.setString(7, customer.getAddress());
			ps.setString(8, customer.getContactNo());
			ps.setString(9, customer.getEmail());
			ps.setString(10, customer.getPassword());
			
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
		String msg = "No customer exists with customer ID: " + customerID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET First_Name = ?"
					+ " where CustomerID = ?");
			
			ps.setString(1, firstName);
			ps.setInt(2, customerID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Customers's first name has been changed to " + firstName;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeCustomerLastName(String lastName, int customerID) throws CustomerException {
		String msg = "No customer exists with customer ID: " + customerID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET Last_Name = ?"
					+ " where CustomerID = ?");
			
			ps.setString(1, lastName);
			ps.setInt(2, customerID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Customers's last name has been changed to " + lastName;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeCustomerFatherName(String fatherName, int customerID) throws CustomerException {
		String msg = "No customer exists with customer ID: " + customerID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET Father_Name = ?"
					+ " where CustomerID = ?");
			
			ps.setString(1, fatherName);
			ps.setInt(2, customerID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Customers's father name has been changed to " + fatherName;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeCustomerMotherName(String motherName, int customerID) throws CustomerException {
		String msg = "No customer exists with customer ID: " + customerID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET Mother_Name = ?"
					+ " where CustomerID = ?");
			
			ps.setString(1, motherName);
			ps.setInt(2, customerID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Customers's mother name has been changed to " + motherName;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeCustomerGender(String gender, int customerID) throws CustomerException {
		String msg = "No customer exists with customer ID: " + customerID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET Gender = ?"
					+ " where CustomerID = ?");
			
			ps.setString(1, gender);
			ps.setInt(2, customerID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Customers's gender has been changed to " + gender;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeCustomerDateOfBirth(String dateOfBirth, int customerID) throws CustomerException {
		String msg = "No customer exists with customer ID: " + customerID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET Date_Of_Birth = ?"
					+ " where CustomerID = ?");
			
			ps.setString(1, dateOfBirth);
			ps.setInt(2, customerID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Customers's date of birth has been changed to " + dateOfBirth;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeCustomerAddress(String address, int customerID) throws CustomerException {
		String msg = "No admin exists with customer ID: " + customerID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Address = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, address);
			ps.setInt(2, customerID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Customer's address has been changed to " + address;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeCustomerContactNo(String contactNo, int customerID) throws CustomerException {
		String msg = "No customer exists with customer ID: " + customerID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET Contact_No = ?"
					+ " where CustomerID = ?");
			
			ps.setString(1, contactNo);
			ps.setInt(2, customerID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Customers's contact no. name has been changed to " + contactNo;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeCustomerEmail(String email, int customerID) throws CustomerException {
		String msg = "No customer exists with customer ID: " + customerID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET Email = ?"
					+ " where CustomerID = ?");
			
			ps.setString(1, email);
			ps.setInt(2, customerID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Customers's contact no. name has been changed to " + email;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String getCustomerPassword(int customerID) throws CustomerException {
		String msg = "No customer exists with admin ID: " + customerID;;
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select Password from "
					+ "customer where CustomerID = ?");
			
			ps.setInt(1, customerID);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				msg = rs.getString("Password");
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeCustomerPassword(String password, int customerID) throws CustomerException {
		String msg = "No customer exists with customer ID: " + customerID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE customer SET Password = ?"
					+ " where CustomerID = ?");
			
			ps.setString(1, password);
			ps.setInt(2, customerID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Customers's contact no. name has been changed to " + password;
			} else {
				throw new CustomerException(msg);
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public List<Customer> showAllCustomers() throws CustomerException {
		List<Customer> customers = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from customer");
			
			ResultSet rs = ps.executeQuery();
			
			customers = new ArrayList<>();
			
			while (rs.next()) {
				Customer customer = new Customer();
				
				customer.setCustomerID(rs.getInt("CustomerID"));
				customer.setFirstName(rs.getString("First_Name"));
				customer.setLastName(rs.getString("Last_Name"));
				customer.setFatherName(rs.getString("Father_Name"));
				customer.setMotherName(rs.getString("Mother_Name"));
				customer.setGender(rs.getString("Gender"));
				customer.setDateOfBirth(rs.getString("Date_Of_Birth"));
				customer.setAddress(rs.getString("Address"));
				customer.setContactNo(rs.getString("Contact_No"));
				customer.setEmail(rs.getString("Email"));
				customer.setPassword(rs.getString("password"));
			} 
			
			if (customers.size() == 0) {
				throw new CustomerException("No customer found");
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		return customers;
	}

}
