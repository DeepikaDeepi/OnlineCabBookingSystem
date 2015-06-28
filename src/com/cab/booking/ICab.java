package com.cab.booking;

public interface ICab 
{
	public double getMinFare();

	public void setMinFare(double minFare);

	public String getCabNo();

	public String getCabType();
	
	public boolean isAvailable();

	public void setAvailable(boolean isAvailable);
	
}
