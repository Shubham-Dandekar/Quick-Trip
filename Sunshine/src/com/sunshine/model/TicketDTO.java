package com.sunshine.model;

import java.time.LocalDateTime;

public class TicketDTO {
	private int ticketID;
	private String name;
	private String startPoint;
	private LocalDateTime startDateTime;
	private String endPoint;
	private LocalDateTime endDateTime;
	private int seatsBooked;
	private String status;
	
	public TicketDTO() {
		super();
	}

	public TicketDTO(int ticketID, String name, String startPoint, LocalDateTime startDateTime, String endPoint,
			LocalDateTime endDateTime, int seatsBooked, String status) {
		super();
		this.ticketID = ticketID;
		this.name = name;
		this.startPoint = startPoint;
		this.startDateTime = startDateTime;
		this.endPoint = endPoint;
		this.endDateTime = endDateTime;
		this.seatsBooked = seatsBooked;
		this.status = status;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TicketDTO [ticketID=" + ticketID + ", name=" + name + ", startPoint=" + startPoint + ", startDateTime="
				+ startDateTime + ", endPoint=" + endPoint + ", endDateTime=" + endDateTime + ", seatsBooked="
				+ seatsBooked + ", status=" + status + "]";
	}
}
