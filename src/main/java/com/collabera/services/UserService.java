package com.collabera.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.collabera.models.Role;
import com.collabera.models.Users;

@Service
public class UserService {
	private static List<Users> userList = new ArrayList<Users>();
//	private static Role[] role = {new Role(1,"Admin")};
//	private static Role[] userRole = {new Role(1,"User")};
	
	private static int id = 2;
	static {
		userList.add(new Users(1,"root","root","root@g.com", "Admin"));
		userList.add(new Users(2,"groot","groot","groot@g.com", "Admin"));
	}
	
	public List<Users> listUsers(){
		return userList;
	}
	
	public void addUser(String name, String password, String email){
		userList.add(new Users(++id,name,password,email, "User"));
	}
	
	public void deleteUser(int id) {
		userList.removeIf(user -> user.getUserId()==id);
	}
	
	public Users getUser(int id) {
		for(Users u: userList) {
			if(u.getUserId()==id)
				return u;	
		}
		return null;
	}
	public boolean validUserName(String username) {
		for(Users u: userList) {
			if(u.getUsername().equals(username))
				return false;	
			else 
				return true;
		}
		return false;
	}
	
	public boolean isValidUser(String username,String password) {
		//write data base connectivity to validate the user
		//rest service or soap service get the details validated
		for(Users u: userList) {
		if(u.getUsername().equals(username) && u.getPassword().equals(password))
			return true;
		else
			return false;
		}
		return false;
	}
	
	public void updateUser(int userId, String username,String password, String email, String role) {
		for(Users u:userList)
			if(userId == u.getUserId()) {
				u.setUsername(username);
				u.setPassword(password);
				u.setEmail(email);
				u.setRole(role);
			}
	}
	
	public Users getUserByName(String userName) {
		for(Users u :userList) {
			if(u.getUsername().equals(userName))
				return u;
		}
		return null;
	}

}
