package com.cab.booking;

public interface IBookingManager 
{
	public void registerUser(IUser user);
	
	public void deleteUser(IUser user);
	
	public void editUserInfo(IUser user);
	
	public void showUserInfo(String userID);
	
	public boolean login(String userName, String password);
	
	public String bookCab(String cabNo, IUser user, String date);
	
	public void cancelCab(String bookingID, IUser user);
	
	public void showBookingHistory(IUser user);
	
	public void showAvailableCabs();
	
	public void showAllCabs(); 
	
	public ISession getSessionInfo();

	public void setSessionInfo(ISession sessionInfo);
}
