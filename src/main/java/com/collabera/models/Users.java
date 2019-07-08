package com.collabera.models;

public class Users {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String role;	
	
	public Users() {
		super();
	}
	
	
	public Users(int userId, String username, String password, String email, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
//	public Role[] getRoles() {
//		return roles;
//	}
//	public void setRoles(Role[] roles) {
//		this.roles = roles;
//	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}