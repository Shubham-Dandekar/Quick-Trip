package com.sunshine.model;

public class Bus {
	private int busID;
	private String busName;
	private String startPoint;
	private String endPoint;
	private String startTime;
	private String endTime;
	private int capacity;
	private int seatsAvailable;
	
	public Bus() {
		super();
	}

	public Bus(int busID, String busName, String startPoint, String endPoint, String startTime, String endTime,
			int capacity, int seatsAvailable) {
		super();
		this.busID = busID;
		this.busName = busName;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.startTime = startTime;
		this.endTime = endTime;
		this.capacity = capacity;
		this.seatsAvailable = seatsAvailable;
	}

	public int getBusID() {
		return busID;
	}

	public void setBusID(int busID) {
		this.busID = busID;
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

	@Override
	public String toString() {
		return "Bus [busID=" + busID + ", busName=" + busName + ", startPoint=" + startPoint + ", endPoint=" + endPoint
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", capacity=" + capacity + ", seatsAvailable="
				+ seatsAvailable + "]";
	}
}
