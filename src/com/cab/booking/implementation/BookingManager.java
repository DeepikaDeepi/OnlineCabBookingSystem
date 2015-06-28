package com.cab.booking.implementation;

import com.cab.booking.IBookingManager;
import com.cab.booking.ISession;
import com.cab.booking.IUser;

public class BookingManager implements IBookingManager 
{

	//private static BookingManager INSTANCE;
	
	private ISession sessionInfo;
	
	/*
	 * Singleton instance
	 
	public static synchronized BookingManager getInstance()
	{
		if(BookingManager.INSTANCE == null)
		{
			BookingManager.INSTANCE = new BookingManager();
		}
		return BookingManager.INSTANCE;
	}
	*/
	
	public BookingManager() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void registerUser(IUser user) {
		if(UserManager.getInstance().addUser(user))
		{
			System.out.println("User addition successful!");
		}
		else
		{
			System.out.println("Oops! Something went wrong! Please try again.");
		}
	}

	@Override
	public void deleteUser(IUser user) {
		if(UserManager.getInstance().deleteUser(user))
		{
			System.out.println("User removal successful!");
		}
		else
		{
			System.out.println("Oops! Something went wrong! Please try again.");
		}		
	}

	@Override
	public void editUserInfo(IUser user) {
		UserManager.getInstance().editUserInfo(user);
	}

	@Override
	public void showUserInfo(String userID) {
		UserManager.getInstance().showUserInfo(userID);
	}

	@Override
	public boolean login(String userName, String password) {
		return Login.getInstance().login(userName, password);
	}

	@Override
	public String bookCab(String cabNo, IUser user, String date) {
		return Booking.getInstance().bookCab(cabNo, user, date);
	}

	@Override
	public void cancelCab(String bookingID, IUser user) {
		Booking.getInstance().cancelCab(bookingID, user);
	}

	@Override
	public void showBookingHistory(IUser user) {
		UserManager.getInstance().showBookingHistory(user);
	}

	@Override
	public void showAvailableCabs() {
		Fleet.getInstance().showAvailableCabs();
	}

	@Override
	public void showAllCabs() {
		Fleet.getInstance().showAllCabs();
	}
	
	public ISession getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(ISession sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

}
