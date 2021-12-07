package com.Donation.charity.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="ProjectFeedbackNew_",uniqueConstraints = @UniqueConstraint(columnNames = "fdemail"))
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String fdemail;
	private String fdsubject;
	private String fdmessage;
	
	public Feedback() {
		super();
	}

	public Feedback(String name, String fdemail, String fdsubject, String fdmessage) {
		super();
		this.name = name;
		this.fdemail = fdemail;
		this.fdsubject = fdsubject;
		this.fdmessage = fdmessage;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFdemail() {
		return fdemail;
	}
	public void setFdemail(String fdemail) {
		this.fdemail = fdemail;
	}
	public String getFdsubject() {
		return fdsubject;
	}
	public void setFdsubject(String fdsubject) {
		this.fdsubject = fdsubject;
	}
	public String getFdmessage() {
		return fdmessage;
	}
	public void setFdmessage(String fdmessage) {
		this.fdmessage = fdmessage;
	}


	
	

	
	

	
	
	
}
