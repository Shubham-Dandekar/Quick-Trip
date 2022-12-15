package com.sunshine.model;

import java.time.LocalDateTime;

public class Bus {
	private int busID;
	private String name;
	private String startPoint;
	private LocalDateTime startDateTime;
	private String endPoint;
	private LocalDateTime endDateTime;
	private int capacity;
	private int seatsAvailable;
	private String busStatus;
	
	public Bus() {
		super();
	}

	public Bus(int busID, String name, String startPoint, LocalDateTime startDateTime, String endPoint,
			LocalDateTime endDateTime, int capacity, int seatsAvailable, String busStatus) {
		super();
		this.busID = busID;
		this.name = name;
		this.startPoint = startPoint;
		this.startDateTime = startDateTime;
		this.endPoint = endPoint;
		this.endDateTime = endDateTime;
		this.capacity = capacity;
		this.seatsAvailable = seatsAvailable;
		this.busStatus = busStatus;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public String getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(String busStatus) {
		this.busStatus = busStatus;
	}

	@Override
	public String toString() {
		return "Bus [busID=" + busID + ", name=" + name + ", startPoint=" + startPoint + ", startDateTime="
				+ startDateTime + ", endPoint=" + endPoint + ", endDateTime=" + endDateTime + ", capacity=" + capacity
				+ ", seatsAvailable=" + seatsAvailable + ", busStatus=" + busStatus + "]";
	}	
}
