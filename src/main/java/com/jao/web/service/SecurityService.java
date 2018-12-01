package com.jao.web.service;

public interface SecurityService {
	String findLoggedInUsername();

	void autologin(String username, String password);
	
	Object getUser();
}
