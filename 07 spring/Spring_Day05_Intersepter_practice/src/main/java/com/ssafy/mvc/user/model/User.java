package com.ssafy.mvc.user.model;

public class User {
	String id; //고유한 
	String name;
	String password;
	
	public User(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
