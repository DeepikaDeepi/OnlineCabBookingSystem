package com.cab.booking.implementation;

import com.cab.booking.IBookingDetails;

public class BookingDetails implements IBookingDetails {
	
	private long bookingID;
	
	private String bookingDate;
	
	private String cabNo;
	
	public BookingDetails(String bookingDate, String cabNo)
	{
		this.bookingDate = bookingDate;
		this.cabNo = cabNo;
	}

	public long getBookingID() {
		return bookingID;
	}

	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getCabNo() {
		return cabNo;
	}

	public void setCabNo(String cabNo) {
		this.cabNo = cabNo;
	}
}
