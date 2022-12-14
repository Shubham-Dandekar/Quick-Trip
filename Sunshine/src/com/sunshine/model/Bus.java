package com.sunshine.model;

import java.time.LocalDateTime;

public class Bus {
	private int busID;
	private String name;
	private String startPoint;
	private LocalDateTime startDateTime;
	private String endPoint;
	private LocalDateTime endDateTime;
	private int seats;
	
	public Bus() {
		super();
	}

	public Bus(String name, String startPoint, LocalDateTime startDateTime, String endPoint, LocalDateTime endDateTime,
			int seats) {
		super();
		this.name = name;
		this.startPoint = startPoint;
		this.startDateTime = startDateTime;
		this.endPoint = endPoint;
		this.endDateTime = endDateTime;
		this.seats = seats;
	}

	public int getBusID() {
		return busID;
	}

	public void setBusID(int busID) {
		this.busID = busID;
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

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Bus [busID=" + busID + ", name=" + name + ", startPoint=" + startPoint + ", startDateTime="
				+ startDateTime + ", endPoint=" + endPoint + ", endDateTime=" + endDateTime + ", seats=" + seats + "]";
	}	
}
