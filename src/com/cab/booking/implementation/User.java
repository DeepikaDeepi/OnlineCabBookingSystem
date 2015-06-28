package com.cab.booking.implementation;

import com.cab.booking.IUser;

public class User implements IUser {

	private String userID;
	private String password;
	private String emailID;
	private String gender;
	private String fullName;
	private String userType;
	
	public User(String userID, String password, String emailID, String gender, String fullName, String userType)
	{
		this.userID = userID;
		this.password = password;
		this.emailID = emailID;
		this.gender = gender;
		this.fullName = fullName;
		this.userType = userType;
	}
	
	public String getUserType() {
		return userType;
	}

	public String getUserID() {
		return userID;
	}

	public String getEmailID() {
		return emailID;
	}

	public String getGender() {
		return gender;
	}

	public String getFullName() {
		return fullName;
	}
	
	public boolean equals(Object obj) {
		return this.userID.equals(((IUser)obj).getUserID());
	}

	@Override
	public void updateEmailID(String emailID) {
		this.emailID = emailID;
	}

	@Override
	public void updateFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String getPassword() {
		return password;
	}

}
