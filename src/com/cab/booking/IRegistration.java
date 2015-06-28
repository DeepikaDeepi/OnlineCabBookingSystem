package com.cab.booking;

public interface IRegistration 
{
	public void registerUser(IUser user);
	
	public void deleteUser(IUser user);
	
	public void editUserInfo(IUser user);
	
	public void showUserInfo(String userID);
}
