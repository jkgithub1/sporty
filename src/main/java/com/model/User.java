package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String name = "";
    @Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", city=" + city + "]";
	}

	private String email = "";
    private String password = "";
    private String city = "";
    
   public User(String name, String email, String password, String city) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
   
	
	
}
