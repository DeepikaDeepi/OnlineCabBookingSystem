package com.cab.booking.implementation;

import com.cab.booking.ISessionManager;

public class SessionManager implements ISessionManager {

	private static SessionManager INSTANCE;
	
	private long SESSION_ID;
	
	private SessionManager()
	{
		this.SESSION_ID = 1000;
	}
	
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
	public String createSession() {
		return String.valueOf(SESSION_ID + 1);
	}
	

}
