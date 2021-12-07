package com.Donation.charity.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="UserRoleNew_")
public class UserRole {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	
	

	public UserRole() {
	}
	
	public UserRole(String username) {
		super();
		this.username = username;
	}
	
	public long getUserid() {
		return id;
	}
	public void setUserid(int userid) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	}
	
	


