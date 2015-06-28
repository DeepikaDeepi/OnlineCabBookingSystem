package com.cab.booking;

public interface IFleet 
{
	public boolean registerCab(String cabType, double minFare, String cabNo);
	
	public boolean unregisterCab(String cabNo);
	
	public void showAvailableCabs();
	
	public void showAllCabs();
	
	public boolean isCabAvailable(String cabNo);
	
	public boolean isValidCab(String cabNo);
	
	public void updateAvailableCabs(String cabNo, boolean availStatus);
}
