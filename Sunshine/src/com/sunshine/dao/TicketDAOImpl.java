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
	public String bookTicket(int customerID, int busID, int seats) throws BusException {
		String msg = "Failed to book ticket...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into ticket(CustomerID, BusID, "
					+ "Seats_Booked, Booking_Status) values (?, ?, ?, ?)");
			
			ps.setInt(1, customerID);
			ps.setInt(2, busID);
			ps.setInt(3, seats);
			ps.setString(4, "Unconfirmed");
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				ps = conn.prepareStatement("select Seats_Available from bus where BusID = ?");
				
				ps.setInt(1, busID);
				
				ResultSet rs = ps.executeQuery();
				int seatsAvailable;
				
				if (rs.next()) {
					seatsAvailable = rs.getInt("Seats_Available") - seats;
					
					ps = conn.prepareStatement("UPDATE bus SET Seats_Available = ? "
							+ "where BusID = ?");
					
					ps.setInt(1, seatsAvailable);
					ps.setInt(2, busID);
					
					ps.executeUpdate();
					
					ps = conn.prepareStatement("select t.TicketID, b.Bus_Name, b.Starting_Point, "
							+ "b.Ending_Point, b.Start_Time, b.End_Time, t.Seats_Booked, "
							+ "t.Booking_Status from ticket t INNER JOIN bus b ON t.BusID = t.BusID "
							+ "where t.CustomerID = ? AND b.BusID = ?");
					
					ps.setInt(1, customerID);
					ps.setInt(2, busID);
					
					rs = ps.executeQuery();
					
					if (rs.next()) {
		    			System.out.println("+----------------------------------------+");
		    			System.out.printf("| Ticket ID: %-27d |\n", rs.getInt("TicketID"));
		    			System.out.printf("| Bus Name: %-28s |\n", rs.getString("Bus_Name"));
		    			System.out.printf("| Start Point: %-26s|\n", rs.getString("Starting_Point"));
		    			System.out.printf("| End Point: %-28s|\n", rs.getString("Ending_Point"));
		    			System.out.printf("| Start Time: %-27s|\n", rs.getString("Start_Time"));
		    			System.out.printf("| End Time: %-29s|\n", rs.getString("End_Time"));
		    			System.out.printf("| Seats Booked: %-25s|\n", rs.getInt("Seats_Booked"));
		    			System.out.printf("| Status: %-31s|\n", rs.getString("Booking_Status"));
		    			System.out.println("+----------------------------------------+");
					}
					
					msg = "Ticket booked successfully...";
				}

			} else {
				throw new BusException("Failed to book ticket...");
			}
			
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}

		return msg;
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
					+ "t.Booking_Status from ticket t INNER JOIN bus b ON t.BusID = b.BusID "
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
				
				if (rs.next()) {
					ticket = new CustomerTicket();
					
					ticket.setTicketID(rs.getInt("TicketID"));
					ticket.setBusName(rs.getString("bus_Name"));
					ticket.setStartPoint(rs.getString("Starting_Point"));
					ticket.setEndPoint(rs.getString("Ending_Point"));
					ticket.setStartTime(rs.getString("Start_Time"));
					ticket.setEndTime(rs.getString("End_Time"));
					ticket.setSeatsBooked(rs.getInt("Seats_Booked"));
					ticket.setBookingStatus(rs.getString("Booking_Status"));
				}
				
			} else {
				throw new BusException("Failed to book ticket...");
			}
			
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}

		return ticket;
	}
	
	@Override
	public List<CustomerTicket> unconfirmedTickets() throws BusException {
		List<CustomerTicket> tickets = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select t.TicketID, b.Bus_Name, b.Starting_Point, "
					+ "b.Ending_Point, b.Start_Time, b.End_Time, t.Seats_Booked, "
					+ "t.Booking_Status from ticket t INNER JOIN bus b ON t.BusID = b.BusID "
					+ "where t.Booking_Status = ?");
			
			ps.setString(1, "Unconfirmed");
			
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

}
