package com.cab.booking.implementation;

import com.cab.booking.IRegistration;
import com.cab.booking.IUser;

public class Registration implements IRegistration 
{

	@Override
	public void registerUser(IUser user) 
	{
		if(UserManager.getInstance().addUser(user))
		{
			System.out.println("User " + user.getUserID() + " (" + user.getEmailID() + ") added successfully!");
		}
		else
		{
			System.out.println("Uhoh! There seems to have been some problem adding you to our system. Please try again. Sorry for the inconveinence.");
		}
	}

	@Override
	public void deleteUser(IUser user) {
		if(UserManager.getInstance().deleteUser(user))
		{
			System.out.println("User " + user.getUserID() + " (" + user.getEmailID() + ") added successfully!");
		}
		else
		{
			System.out.println("Uhoh! There seems to have been some problem removing you to our system. Please try again. Sorry for the inconveinence.");
		}		
	}

	@Override
	public void editUserInfo(IUser user) {
		UserManager.getInstance().editUserInfo(user);
		System.out.println("User, " + user.getUserID() + " info updated.");
	}

	@Override
	public void showUserInfo(String userID) {
		UserManager.getInstance().showUserInfo(userID);
	}

}
