package com.Donation.charity.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DonationDetails")
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private String othercategory;
	private String comment;
	
	@Enumerated(EnumType.STRING)
	private DonationCategory donationcategory;
	
	public Donation(){
		
	}

	public Donation( DonationCategory donationcategory,String othercategory,String description,String comment) {
		super();
		this.othercategory = othercategory;
		this.comment = comment;
		this.description = description;
		this.donationcategory = donationcategory;
	}

	/*	public Donation(String othercategory,String comment, String description) {
		super();
	//	this.category=category;
		this.othercategory=othercategory;
		this.comment = comment;
		this.description = description;
	}*/
	
	public DonationCategory getDonationcategory() {
		return donationcategory;
	}
	public void setDonationcategory(DonationCategory donationcategory) {
		this.donationcategory = donationcategory;
	}
	public String getOthercategory() {
		return othercategory;
	}
	public void setOthercategory(String othercategory) {
		this.othercategory = othercategory;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDiscription(String description) {
		this.description = description;
	}
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
