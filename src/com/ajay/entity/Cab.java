package com.ajay.entity;

import java.util.Calendar;

public class Cab implements Cloneable{

	private String cabNo;
	private Area initialLocation;
	private Calendar currentLocationTime;
	
	public Cab() {}
	
	public Cab(String cabNo, Area initialLocation, Calendar currentLocationTime) {
		this.cabNo = cabNo;
		this.initialLocation = initialLocation;
		this.currentLocationTime = currentLocationTime;
	}
	public String getCabNo() {
		return cabNo;
	}
	public void setCabNo(String cabNo) {
		this.cabNo = cabNo;
	}
	public Area getInitialLocation() {
		return initialLocation;
	}
	public void setInitialLocation(Area initialLocation) {
		this.initialLocation = initialLocation;
	}
	public Calendar getCurrentLocationTime() {
		return currentLocationTime;
	}
	public void setCurrentLocationTime(Calendar currentLocationTime) {
		this.currentLocationTime = currentLocationTime;
	}

	@Override
	public Cab clone() throws CloneNotSupportedException {
		Cab cab=new Cab(this.cabNo,null,this.currentLocationTime);
		Area currentLocation =(Area)this.initialLocation.clone();
		cab.setInitialLocation(currentLocation);
		return cab;
	}
	
}
