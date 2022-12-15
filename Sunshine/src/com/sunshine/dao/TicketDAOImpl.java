package com.sunshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunshine.exception.BusException;
import com.sunshine.model.CustomerTicket;
import com.sunshine.utility.DBUtil;

public class TicketDAOImpl implements TicketDAO{

	@Override
	public CustomerTicket bookTicket(int customerID, int busID, int seats) throws BusException {
		CustomerTicket ticket = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into ticket(CustomerID, BusID, "
					+ "Seats_Booked, Booking_Status) values (?, ?, ?, ?)");
			
			ps.setInt(1, customerID);
			ps.setInt(2, busID);
			ps.setInt(3, seats);
			ps.setString(2, "Unconfirmed");
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				ps = conn.prepareStatement("select t.TicketID, b.Bus_Name, b.Starting_Point, "
						+ "b.Ending_Point, b.Start_Time, b.End_Time, t.Seats_Booked, "
						+ "t.Booking_Status from ticket t INNER JOIN bus b ON t.BusID = t.BusID "
						+ "where t.CustomerID = ? AND BusID = ?");
				
				ps.setInt(1, customerID);
				ps.setInt(2, busID);
				
				ResultSet rs = ps.executeQuery();
				
				ticket = new CustomerTicket();
				
				ticket.setTicketID(rs.getInt("TicketID"));
				ticket.setBusName(rs.getString("bus_Name"));
				ticket.setStartPoint(rs.getString("Starting_Point"));
				ticket.setEndPoint(rs.getString("Ending_Point"));
				ticket.setStartTime(rs.getString("Start_Time"));
				ticket.setEndTime(rs.getString("End_Time"));
				ticket.setSeatsBooked(rs.getInt("Seats_Booked"));
				ticket.setBookingStatus(rs.getString("Booking_Status"));
				
			} else {
				throw new BusException("Failed to book ticket...");
			}
			
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}

		return ticket;
	}

	@Override
	public CustomerTicket cancelTicket(int ticketID) throws BusException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerTicket> checkAllTickets(int customerID) throws BusException {
		List<CustomerTicket> tickets = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select t.TicketID, b.Bus_Name, b.Starting_Point, "
					+ "b.Ending_Point, b.Start_Time, b.End_Time, t.Seats_Booked, "
					+ "t.Booking_Status from ticket t INNER JOIN bus b ON t.BusID = t.BusID "
					+ "where t.CustomerID = ?");
			
			ps.setInt(1, customerID);
			
			ResultSet rs = ps.executeQuery();
			
			tickets = new ArrayList<>();
			
			while (rs.next()) {
				CustomerTicket ticket = new CustomerTicket();
				
				ticket.setTicketID(rs.getInt("TicketID"));
				ticket.setBusName(rs.getString("bus_Name"));
				ticket.setStartPoint(rs.getString("Starting_Point"));
				ticket.setEndPoint(rs.getString("Ending_Point"));
				ticket.setStartTime(rs.getString("Start_Time"));
				ticket.setEndTime(rs.getString("End_Time"));
				ticket.setSeatsBooked(rs.getInt("Seats_Booked"));
				ticket.setBookingStatus(rs.getString("Booking_Status"));
				
				tickets.add(ticket);
			}
			
			if (tickets.size() == 0) {
				throw new BusException("No ticket found...");
			}
			
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}

		return tickets;
	}

	@Override
	public CustomerTicket confirmTicket(int ticketID) throws BusException {
		CustomerTicket ticket = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE ticket SET Booking_Status = ? "
					+ "where TicketID = ?");
			
			ps.setString(1, "Confirmed");
			ps.setInt(2, ticketID);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				ps = conn.prepareStatement("select t.TicketID, b.Bus_Name, b.Starting_Point, "
						+ "b.Ending_Point, b.Start_Time, b.End_Time, t.Seats_Booked, "
						+ "t.Booking_Status from ticket t INNER JOIN bus b ON t.BusID = t.BusID "
						+ "where t.TicketID = ?");
				
				ps.setInt(1, ticketID);
				
				ResultSet rs = ps.executeQuery();
				
				ticket = new CustomerTicket();
				
				ticket.setTicketID(rs.getInt("TicketID"));
				ticket.setBusName(rs.getString("bus_Name"));
				ticket.setStartPoint(rs.getString("Starting_Point"));
				ticket.setEndPoint(rs.getString("Ending_Point"));
				ticket.setStartTime(rs.getString("Start_Time"));
				ticket.setEndTime(rs.getString("End_Time"));
				ticket.setSeatsBooked(rs.getInt("Seats_Booked"));
				ticket.setBookingStatus(rs.getString("Booking_Status"));
				
			} else {
				throw new BusException("Failed to book ticket...");
			}
			
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}

		return ticket;
	}
}
