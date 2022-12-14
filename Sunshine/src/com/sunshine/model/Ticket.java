package com.sunshine.model;

public class Ticket {
	private int ticketID;
	private int seatsBooked;
	private Bus bus;
	private String status;
	
	public Ticket() {
		super();
	}

	public Ticket(int ticketID, int seatsBooked, Bus bus, String status) {
		super();
		this.ticketID = ticketID;
		this.seatsBooked = seatsBooked;
		this.bus = bus;
		this.status = status;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public int getSeats() {
		return seatsBooked;
	}

	public void setSeats(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ticket [ticketID=" + ticketID + ", seatsBooked=" + seatsBooked + ", bus=" + bus + ", status=" + status + "]";
	}
}
