package com.sunshine.dao;

import java.util.List;

import com.sunshine.exception.BusException;
import com.sunshine.model.CustomerTicket;

public interface TicketDAO {
	public String bookTicket(int customerID, int busID, int seats) throws BusException;
	
	public CustomerTicket cancelTicket(int ticketID) throws BusException;
	
	public List<CustomerTicket> checkAllTickets(int customerID) throws BusException;
	
	public CustomerTicket confirmTicket(int ticketID) throws BusException;
	
	public List<CustomerTicket> unconfirmedTickets() throws BusException;
}
