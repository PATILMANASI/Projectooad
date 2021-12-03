package com.Donation.charity.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="DonationDetailsNewTable")
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int donor_id;
	private int ngo_id;
	
	private String description;
	/**
	 * 
	 */
	private String othercategory;

    private String city;

	private String comment;
//	private String username;
	
	
	

	  
	/*@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinColumn(name = "donor_id", referencedColumnName = "id")*/
//	private Donor donor;
	
	@Enumerated(EnumType.STRING)
	private DonationCategory donationcategory;
	
	public Donation(){
		
	}

	

	public int getDonor_id() {
		return donor_id;
	}



	public void setDonor_id(int donor_id) {
		this.donor_id = donor_id;
	}



	public Donation(int donor_id, String description, String othercategory, String comment,
			DonationCategory donationcategory,String city) {
		super();
		this.donor_id = donor_id;
		this.description = description;
		this.othercategory = othercategory;
		this.comment = comment;
		this.donationcategory = donationcategory;
		this.city=city;
	}



	/*	public Donation(String othercategory,String comment, String description) {
		super();
	//	this.category=category;
		this.othercategory=othercategory;
		this.comment = comment;
		this.description = description;
	}*/
	
	public void setDescription(String description) {
		this.description = description;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



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



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	/**
	 * @return the ngo_id
	 */
	public int getNgo_id() {
		return ngo_id;
	}



	/**
	 * @param ngo_id the ngo_id to set
	 */
	public void setNgo_id(int ngo_id) {
		this.ngo_id = ngo_id;
	}

	

	

/*	public int getDonor_fid() {
		return donor_fid;
	}

	public void setDonor_fid(int donor_fid) {
		this.donor_fid = donor_fid;
	}*/

	
	

}
