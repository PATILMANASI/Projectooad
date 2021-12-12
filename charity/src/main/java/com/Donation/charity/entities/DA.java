package com.Donation.charity.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="DeliveryAgent")
public class DA extends User{
	@Enumerated(EnumType.STRING)
	private RegistrationStatus registrationstatus=RegistrationStatus.Not_Verified;
	
	private String aadharnumber;
	
	

	
	

	public DA(RegistrationStatus registrationstatus,String name, String email, String password, String repassword, String city, String phonenumber,
			String pincode, String address, Collection<UserRole> userroles,String aadharnumber) {
		super(name, email, password, repassword, city, phonenumber, pincode, address, userroles);
		// TODO Auto-generated constructor stub
		this.registrationstatus=registrationstatus;
		this.aadharnumber=aadharnumber;
	
	}







	public DA() {
		
	}







	/**
	 * @return the registrationstatus
	 */
	public RegistrationStatus getRegistrationstatus() {
		return registrationstatus;
	}







	/**
	 * @param registrationstatus the registrationstatus to set
	 */
	public void setRegistrationstatus(RegistrationStatus registrationstatus) {
		this.registrationstatus = registrationstatus;
	}







	/**
	 * @return the aadharnumber
	 */
	public String getAadharnumber() {
		return aadharnumber;
	}







	/**
	 * @param aadharnumber the aadharnumber to set
	 */
	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	
}
