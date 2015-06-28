package com.cab.booking.implementation;

import com.cab.booking.ISessionManager;
import com.cab.booking.IUser;

public class SessionManager implements ISessionManager {

	private static SessionManager INSTANCE;
	
	/*
	 * Singleton instance
	 */
	public static synchronized SessionManager getInstance()
	{
		if(SessionManager.INSTANCE == null)
		{
			SessionManager.INSTANCE = new SessionManager();
		}
		return SessionManager.INSTANCE;
	}
	
	@Override
	public String createSession(IUser user) {

		return null;
	}
	

}
