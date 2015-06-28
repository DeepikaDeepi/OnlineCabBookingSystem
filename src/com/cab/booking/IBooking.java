package com.cab.booking;

public interface IBooking 
{
	public String bookCab(String cabNo, IUser user, String date);
	
	public void cancelCab(String bookingID, IUser user);
}
