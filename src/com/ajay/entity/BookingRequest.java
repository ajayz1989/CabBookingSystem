package com.ajay.entity;

import java.util.Calendar;

/**
 * Class for storing booking request details .
 * 
 * @author ajaykumar
 *
 */
public class BookingRequest {

	private String bookingId;
	private Area pickUpArea;
	private Area dropArea;
	private Calendar pickUpTime;
	private Cab assignedCab;
	private double profit;
	
	public BookingRequest() {}
	
	public BookingRequest(String bookingId, Area pickUpArea, Area dropArea, Calendar pickUpTime, Cab assignedCab) {
		this.bookingId = bookingId;
		this.pickUpArea = pickUpArea;
		this.dropArea = dropArea;
		this.pickUpTime = pickUpTime;
		this.assignedCab = assignedCab;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public Area getPickUpArea() {
		return pickUpArea;
	}
	public void setPickUpArea(Area pickUpArea) {
		this.pickUpArea = pickUpArea;
	}
	public Area getDropArea() {
		return dropArea;
	}
	public void setDropArea(Area dropArea) {
		this.dropArea = dropArea;
	}
	public Calendar getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(Calendar pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public Cab getAssignedCab() {
		return assignedCab;
	}
	public void setAssignedCab(Cab assignedCab) {
		this.assignedCab = assignedCab;
	}
	
	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookingRequest [bookingId=").append(bookingId).append(", pickUpArea=").append(pickUpArea)
				.append(", dropArea=").append(dropArea).append(", pickUpTime=").append(pickUpTime)
				.append(", assignedCab=").append(assignedCab).append("]");
		return builder.toString();
	}
	
	
	
}
