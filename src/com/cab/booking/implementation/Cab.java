package com.cab.booking.implementation;

import com.cab.booking.ICab;

public class Cab implements ICab {

	private final String cabNo;
	
	private final String cabType;
	
	private double minFare;
	
	private boolean isAvailable;
	
	public Cab(String cabNo, String cabType, double minFare)
	{
		this.cabNo = cabNo;
		this.cabType = cabType;
		this.minFare = minFare;
		this.isAvailable = true;
	}

	public double getMinFare() {
		return minFare;
	}

	public void setMinFare(double minFare) {
		this.minFare = minFare;
	}

	public String getCabNo() {
		return cabNo;
	}

	public String getCabType() {
		return cabType;
	}
	
	public boolean equals(Object o)
	{
		return this.cabNo.equals(((ICab)o).getCabNo());
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}
