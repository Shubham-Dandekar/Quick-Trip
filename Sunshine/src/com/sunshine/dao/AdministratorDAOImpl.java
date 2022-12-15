package com.sunshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunshine.exception.AdministratorException;
import com.sunshine.model.Address;
import com.sunshine.model.Administrator;
import com.sunshine.utility.DBUtil;

public class AdministratorDAOImpl implements AdministratorDAO{

	@Override
	public String adminLogIn(String email, String password) throws AdministratorException {
		String adminID = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select AdminID from administrator where Email = ? "
					+ "AND Password = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				adminID = rs.getString("AdminID");
			} else {
				throw new AdministratorException("Bad credentials...");
			}
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return adminID;
	}

	@Override
	public String getAdminName(String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;;
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select First_Name, Last_Name from "
					+ "administrator where AdminID = ?");
			
			ps.setString(1, adminID);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				String firstName = rs.getString("First_Name");
				String lastName = rs.getString("Lsst_Name");
				msg = firstName + " " + lastName;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public Administrator showAdminDetails(String adminID) throws AdministratorException {
		Administrator admin = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select First_Name, Last_Name, Father_Name, "
					+ "Mother_Name, Gender, Date_Of_Birth, AddressID, Contact_No, Email from administrator "
					+ "where AdminID=?");
			
			ps.setString(1, adminID);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				admin = new Administrator();
				
				admin.setAdminID(adminID);
				admin.setFirstName(rs.getString("First_Name"));
				admin.setLastName(rs.getString("Last_Name"));
				admin.setFatherName(rs.getString("Father_Name"));
				admin.setMotherName(rs.getString("Mother_Name"));
				admin.setGender(rs.getString("Gender"));
				admin.setDateOfBirth(rs.getString("Date_Of_Birth"));
				admin.setAddressID(rs.getString("AddressID"));
				admin.setContactNo(rs.getInt("Contact_No"));
				admin.setEmail(rs.getString("Email"));
			} else {
				throw new AdministratorException("Admin not found");
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}

		return admin;
	}

	@Override
	public String registerNewAdmin(Administrator admin) throws AdministratorException {
		String msg = "Failed to register new administrator...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into administrator values(?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, admin.getAdminID());
			ps.setString(2, admin.getFirstName());
			ps.setString(3, admin.getFatherName());
			ps.setString(4, admin.getLastName());
			ps.setString(5, admin.getMotherName());
			ps.setString(6, admin.getDateOfBirth());
			ps.setString(7, admin.getGender());
			ps.setString(8, admin.getAddressID());
			ps.setInt(9, admin.getContactNo());
			ps.setString(10, admin.getEmail());
			ps.setString(11, admin.getPassword());
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = admin.getFirstName() + " " + admin.getLastName() + " registered as administrator successfylly...";
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminFirstName(String firstName, String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET First_Name = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, firstName);
			ps.setString(2, adminID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's first name has been changed to " + firstName;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminLastName(String lastName, String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Last_Name = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, lastName);
			ps.setString(2, adminID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's first name has been changed to " + lastName;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminFatherName(String fatherName, String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Father_Name = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, fatherName);
			ps.setString(2, adminID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's first name has been changed to " + fatherName;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminMotherName(String motherName, String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Mother_Name = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, motherName);
			ps.setString(2, adminID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's first name has been changed to " + motherName;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminGender(String gender, String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Gender = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, gender);
			ps.setString(2, adminID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's first name has been changed to " + gender;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminDateOfBirth(String dateOfBirth, String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Date_Of_Birth = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, dateOfBirth);
			ps.setString(2, adminID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's first name has been changed to " + dateOfBirth;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminAddress(Address address, String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select AddressID from administrator"
					+ " where AdminID = ?");
			
			ps.setString(1, adminID);
			
			ResultSet rs = ps.executeQuery();
			
			String addressID = null;
			
			if (rs.next()) {
				addressID = rs.getString("AddressID");
			} else {
				throw new AdministratorException(msg);
			}
			
			ps = conn.prepareStatement("UPDATE addresss SET City = ?, State = ?, Country = ?"
					+ " where AddressID = ?");
			
			ps.setString(1, address.getCity());
			ps.setString(2, address.getState());
			ps.setString(3, address.getCountry());
			ps.setString(4, addressID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's address has been changed to " + address.getCity() + ", "
						+ "" + address.getState() + ", " + address.getCountry();
			} else {
				throw new AdministratorException("No address exists with address ID: "
						+ "" + addressID);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminContactNo(String contactNo, String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Contact_No = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, contactNo);
			ps.setString(2, adminID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's first name has been changed to " + contactNo;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminEmail(String email, String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Email = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, email);
			ps.setString(2, adminID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's first name has been changed to " + email;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String getAdminPassword(String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;;
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select Password from "
					+ "administrator where AdminID = ?");
			
			ps.setString(1, adminID);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				msg = rs.getString("Password");
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminPassword(String password, String adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Password = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, password);
			ps.setString(2, adminID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's first name has been changed to " + password;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

}
