package com.cab.booking;

public interface IUserManager 
{
	public boolean addUser(IUser user);
	
	public boolean deleteUser(IUser user);
	
	public void listAllRegisteredUsers();
	
	public boolean saveBookingHistory(String userID, IBookingDetails booking);
	
	public void showBookingHistory(IUser user);
	
	public void showUserInfo(String userID);
	
	public boolean authenticate(String userID, String password);
	
	public IUser getUser(String userID);
}
