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
@Table(name="DonationTable")
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int donorid;
	private int ngoid;
	private int daid;
	
	private String description;
	
	private String othercategory;

    private String city;

	private String comment;
	@Enumerated(EnumType.STRING)
	private DonationStatus donationstatus=DonationStatus.Not_Booked;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "donor_id", referencedColumnName = "id",insertable = false, updatable = false)
	private Donor donor;
	
	
	

	  
	/*@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinColumn(name = "donor_id", referencedColumnName = "id")*/
//	private Donor donor;
	
	@Enumerated(EnumType.STRING)
	private DonationCategory donationcategory;
	
	public Donation(){
		
	}

	

	public int getDonorid() {
		return donorid;
	}



	public void setDonorid(int donorid) {
		this.donorid = donorid;
	}



	public Donation(int donorid, String description, String othercategory, String comment,
			DonationCategory donationcategory,String city,DonationStatus donationstatus) {
		super();
		this.donorid = donorid;
		this.description = description;
		this.othercategory = othercategory;
		this.comment = comment;
		this.donationcategory = donationcategory;
		this.city=city;
		this.donationstatus=this.donationstatus;

	}

	
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



	
	public int getNgoid() {
		return ngoid;
	}




	public void setNgoid(int ngoid) {
		this.ngoid = ngoid;
	}



	
	public int getDaid() {
		return daid;
	}



	public void setDaid(int daid) {
		this.daid = daid;
	}



	public DonationStatus getDonationstatus() {
		return donationstatus;
	}



	public void setDonationstatus(DonationStatus donationstatus) {
		this.donationstatus = donationstatus;
	}


	


	

	


	
	

}
