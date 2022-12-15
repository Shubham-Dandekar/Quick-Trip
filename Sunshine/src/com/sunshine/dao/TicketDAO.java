package com.sunshine.dao;

import java.util.List;

import com.sunshine.exception.CustomerException;
import com.sunshine.model.TicketDTO;

public interface TicketDAO {
	public TicketDTO bookTicket(int customerID, int busID, int seats) throws CustomerException;
	
	public TicketDTO cancelTicket(int customerID, int busID) throws CustomerException;
	
	public TicketDTO cancelTicketPartially(int customerID, int busID, int seats) throws CustomerException;
	
	public List<TicketDTO> checkAllTickets(int customerID) throws CustomerException;
}
