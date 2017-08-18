package com.ajay.entity;

/**
 * Entity for storing Area information .
 */
public class Area implements Cloneable{
	
	private Integer areaCode;
	private Integer areaShortId;
	
	public Area(Integer areaCode, Integer areaShortId) {
		this.areaCode = areaCode;
		this.areaShortId = areaShortId;
	}
	public Integer getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}
	public Integer getAreaShortId() {
		return areaShortId;
	}
	public void setAreaShortId(Integer areaShortId) {
		this.areaShortId = areaShortId;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
