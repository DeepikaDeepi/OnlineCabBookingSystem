package com.cab.booking.implementation;

import com.cab.booking.ILogin;

public class Login implements ILogin {

	private static ILogin INSTANCE;
	
	public static synchronized ILogin getInstance()
	{
		if(Login.INSTANCE == null)
		{
			Login.INSTANCE = new Login();
		}
		return Login.INSTANCE;
	}
	
	@Override
	public boolean login(String userName, String password) {
		return UserManager.getInstance().authenticate(userName, password);
	}

}
