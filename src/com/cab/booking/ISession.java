package com.cab.booking;

public interface ISession {

	public long getSessionID();

	public void setSessionID(long sessionID);

	public IUser getLoggedInUser();

	public void setLoggedInUser(IUser loggedInUser);
}
