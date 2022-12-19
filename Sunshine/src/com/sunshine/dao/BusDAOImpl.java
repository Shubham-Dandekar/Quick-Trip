package com.sunshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunshine.exception.BusException;
import com.sunshine.exception.CustomerException;
import com.sunshine.model.Bus;
import com.sunshine.model.Customer;
import com.sunshine.utility.DBUtil;

public class BusDAOImpl implements BusDAO{

	@Override
	public String addNewBus(Bus bus) throws BusException {
		String msg = "Failed to add new bus...";
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into bus (Bus_Name, Starting_Point,"
					+ " Ending_Point, Start_Time, End_Time, Capacity, "
					+ "Seats_Available) values(?,?,?,?,?,?,?)");
			
			ps.setString(1, bus.getBusName());
			ps.setString(2, bus.getStartPoint());
			ps.setString(3, bus.getEndPoint());
			ps.setString(4, bus.getStartTime());
			ps.setString(5, bus.getEndTime());
			ps.setInt(6, bus.getCapacity());
			ps.setInt(7, bus.getSeatsAvailable());
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				msg = bus.getBusName() + " added successfully...";
			} else {
				throw new BusException(msg);
			}
			
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public List<Bus> showAllBus() throws BusException {
		List<Bus> buses = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from bus");
			
			ResultSet rs = ps.executeQuery();
			
			buses = new ArrayList<>();
			
			while (rs.next()) {
				Bus bus = new Bus();
				
				bus.setBusID(rs.getInt("BusID"));
				bus.setBusName(rs.getString("Bus_Name"));
				bus.setStartPoint(rs.getString("Starting_Point"));
				bus.setEndPoint(rs.getString("Ending_Point"));
				bus.setStartTime(rs.getString("Start_Time"));
				bus.setEndTime(rs.getString("End_Time"));
				bus.setCapacity(rs.getInt("Capacity"));
				bus.setSeatsAvailable(rs.getInt("Seats_Available"));
				
				buses.add(bus);
			} 
			
			if (buses.size() == 0) {
				throw new BusException("No bus found");
			}
			
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}

		return buses;
	}

	@Override
	public List<Customer> showAllCustomersByBus(int busID) throws CustomerException {
		List<Customer> customers = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select c.* from (customer c INNER JOIN "
					+ " ticket t ON c.CustomerID = t.customerID) INNER JOIN bus b ON "
					+ "b.BusID = t.BusID where t.BusID = ?");
			
			ps.setInt(1, busID);
			
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
				customer.setAddress(rs.getString("AddressID"));
				customer.setContactNo(rs.getString("Contact_No"));
				customer.setEmail(rs.getString("Email"));
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
