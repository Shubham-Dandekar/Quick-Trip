package com.sunshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunshine.exception.AdministratorException;
import com.sunshine.model.Administrator;
import com.sunshine.utility.DBUtil;

public class AdministratorDAOImpl implements AdministratorDAO{

	@Override
	public int adminLogIn(String email, String password) throws AdministratorException {
		int adminID = -1;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select AdminID from administrator where Email = ? "
					+ "AND Password = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				adminID = rs.getInt("AdminID");
			} else {
				throw new AdministratorException("Bad credentials...");
			}
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return adminID;
	}

	@Override
	public String getAdminName(int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;;
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select First_Name, Last_Name from "
					+ "administrator where AdminID = ?");
			
			ps.setInt(1, adminID);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				String firstName = rs.getString("First_Name");
				String lastName = rs.getString("Last_Name");
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
	public Administrator showAdminDetails(int adminID) throws AdministratorException {
		Administrator admin = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select First_Name, Last_Name, Father_Name, "
					+ "Mother_Name, Gender, Date_Of_Birth, Address, Contact_No, Email from administrator "
					+ "where AdminID=?");
			
			ps.setInt(1, adminID);
			
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
				admin.setAddress(rs.getString("Address"));
				admin.setContactNo(rs.getString("Contact_No"));
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
			PreparedStatement ps = conn.prepareStatement("insert into administrator (First_Name, "
					+ "Father_Name, Last_Name, Mother_Name, Date_Of_Birth, Gender, Address, "
					+ "Contact_No, Email, Password) values (?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, admin.getFirstName());
			ps.setString(2, admin.getFatherName());
			ps.setString(3, admin.getLastName());
			ps.setString(4, admin.getMotherName());
			ps.setString(5, admin.getDateOfBirth());
			ps.setString(6, admin.getGender());
			ps.setString(7, admin.getAddress());
			ps.setString(8, admin.getContactNo());
			ps.setString(9, admin.getEmail());
			ps.setString(10, admin.getPassword());
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = admin.getFirstName() + " " + admin.getLastName() + " "
						+ "registered as administrator successfully...";
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminFirstName(String firstName, int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET First_Name = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, firstName);
			ps.setInt(2, adminID);
			
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
	public String changeAdminLastName(String lastName, int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Last_Name = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, lastName);
			ps.setInt(2, adminID);
			
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
	public String changeAdminFatherName(String fatherName, int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Father_Name = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, fatherName);
			ps.setInt(2, adminID);
			
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
	public String changeAdminMotherName(String motherName, int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Mother_Name = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, motherName);
			ps.setInt(2, adminID);
			
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
	public String changeAdminGender(String gender, int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Gender = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, gender);
			ps.setInt(2, adminID);
			
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
	public String changeAdminDateOfBirth(String dateOfBirth, int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Date_Of_Birth = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, dateOfBirth);
			ps.setInt(2, adminID);
			
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
	public String changeAdminAddress(String address, int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Address = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, address);
			ps.setInt(2, adminID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = "Admin's address has been changed to " + address;
			} else {
				throw new AdministratorException(msg);
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String changeAdminContactNo(String contactNo, int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Contact_No = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, contactNo);
			ps.setInt(2, adminID);
			
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
	public String changeAdminEmail(String email, int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Email = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, email);
			ps.setInt(2, adminID);
			
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
	public String getAdminPassword(int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;;
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select Password from "
					+ "administrator where AdminID = ?");
			
			ps.setInt(1, adminID);
			
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
	public String changeAdminPassword(String password, int adminID) throws AdministratorException {
		String msg = "No admin exists with admin ID: " + adminID;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrator SET Password = ?"
					+ " where AdminID = ?");
			
			ps.setString(1, password);
			ps.setInt(2, adminID);
			
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
