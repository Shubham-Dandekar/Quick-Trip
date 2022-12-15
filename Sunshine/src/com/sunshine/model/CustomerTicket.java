package com.sunshine.model;

public class CustomerTicket {
	private int ticketID;
	private String busName;
	private String startPoint;
	private String endPoint;
	private String startTime;
	private String endTime;
	private int seatsBooked;
	private String bookingStatus;
	
	public CustomerTicket() {
		super();
	}

	public CustomerTicket(int ticketID, String busName, String startPoint, String endPoint, String startTime,
			String endTime, int seatsBooked, String bookingStatus) {
		super();
		this.ticketID = ticketID;
		this.busName = busName;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seatsBooked = seatsBooked;
		this.bookingStatus = bookingStatus;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "CustomerTicket [ticketID=" + ticketID + ", busName=" + busName + ", startPoint=" + startPoint
				+ ", endPoint=" + endPoint + ", startTime=" + startTime + ", endTime=" + endTime + ", seatsBooked="
				+ seatsBooked + ", bookingStatus=" + bookingStatus + "]";
	}
}
