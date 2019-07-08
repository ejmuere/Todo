package com.collabera.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean isValidUserS(String username,String password) {
		//write data base connectivity to validate the user
		//rest service or soap service get the details validated
		if(username.equals("root") && password.equals("root"))
			return true;
		else
			return false;
	}
	 
	

}
