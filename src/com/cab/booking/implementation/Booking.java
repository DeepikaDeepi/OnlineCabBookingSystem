package com.cab.booking.implementation;

import java.util.HashMap;
import java.util.Map;

import com.cab.booking.IBooking;
import com.cab.booking.IUser;

public class Booking implements IBooking 
{
	private static IBooking INSTANCE;
	
	private Long bookingID;
	
	private Map<String, String> bookingList;
	
	public static synchronized IBooking getInstance()
	{
		if(Booking.INSTANCE == null)
		{
			Booking.INSTANCE = new Booking();
		}
		return Booking.INSTANCE;
	}
	
	private Booking()
	{
		this.bookingID = new Long(1000);
		this.bookingList = new HashMap<String, String>();
	}
	
	public String bookCab(String cabNo, IUser user, String date)
	{
		if(Fleet.getInstance().isValidCab(cabNo))
		{
			System.out.println("Sorry, the cab number specified is does not exist in our fleet!");
			return null;
		}
		
		if(Fleet.getInstance().isCabAvailable(cabNo))
		{
			System.out.println("Sorry, the cab number specified is not available at the moment!");
			return null;
		}
		String bookingID = String.valueOf(this.bookingID + 1);
		//Record booking history for user
		BookingDetails bookingDetail = new BookingDetails(date, cabNo);
		bookingDetail.setBookingID(Long.valueOf(bookingID));
		UserManager.getInstance().saveBookingHistory(user.getUserID(), bookingDetail);
		
		//Update cab availability status in fleet
		Fleet.getInstance().updateAvailableCabs(cabNo, false);
		
		//Store map of cab booked per booking ID
		this.bookingList.put(bookingID, cabNo);
		return bookingID;
	}

	@Override
	public void cancelCab(String bookingID, IUser user) {
		if(this.bookingList.get(bookingID) == null)
		{
			System.out.println("Sorry, no booking with that booking ID found!");
			return;
		}

		//Change the cab's availability status back to available
		Fleet.getInstance().updateAvailableCabs(this.bookingList.get(bookingID), true);
	}
}
