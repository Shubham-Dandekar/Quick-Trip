package com.sunshine.model;

public class CustometTicket {
	private String customerID;
	private int ticketID;
	
	public CustometTicket() {
		super();
	}

	public CustometTicket(String customerID, int ticketID) {
		super();
		this.customerID = customerID;
		this.ticketID = ticketID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	@Override
	public String toString() {
		return "CustometTicket [customerID=" + customerID + ", ticketID=" + ticketID + "]";
	}
}
