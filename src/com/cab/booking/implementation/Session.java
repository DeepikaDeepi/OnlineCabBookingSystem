package com.cab.booking.implementation;

import com.cab.booking.ISession;
import com.cab.booking.IUser;

public class Session implements ISession {
	
	private long sessionID;
	
	private IUser loggedInUser;

	public long getSessionID() {
		return sessionID;
	}

	public void setSessionID(long sessionID) {
		this.sessionID = sessionID;
	}

	public IUser getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(IUser loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	
}
