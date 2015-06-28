package com.cab.booking;

public interface IUser 
{
	public String getUserID();

	public String getEmailID();

	public String getGender();

	public String getFullName();
	
	public void updateEmailID(String emailID);
	
	public void updateFullName(String fullName);
	
	public String getPassword();
	
	public String getUserType();
}
