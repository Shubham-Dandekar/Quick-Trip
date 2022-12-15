package com.sunshine.dao;

import java.util.List;

import com.sunshine.exception.CustomerException;
import com.sunshine.model.TicketDTO;

public class TicketDAOImpl implements TicketDAO{

	@Override
	public TicketDTO bookTicket(int customerID, int busID, int seats) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketDTO cancelTicket(int customerID, int busID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketDTO cancelTicketPartially(int customerID, int busID, int seats) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TicketDTO> checkAllTickets(int customerID) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
