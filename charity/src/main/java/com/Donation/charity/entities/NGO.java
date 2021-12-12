package com.Donation.charity.entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="NGO")
public class NGO extends User{
	@Enumerated(EnumType.STRING)
	private RegistrationStatus registrationstatus=RegistrationStatus.Not_Verified;
	
	private String ngoregistrationnumber;
	private String ngoregdate;
	
	public RegistrationStatus getRegistrationstatus() {
		return registrationstatus;
	}


	public void setRegistrationstatus(RegistrationStatus registrationstatus) {
		this.registrationstatus = registrationstatus;
	}


	public NGO(String name,String registrationnumber,String ngoregdate, String email, String password, String repassword, String city, String phonenumber,
			String pincode, String address, Collection<UserRole> userroles) {
		super(name, email, password, repassword, city, phonenumber, pincode, address, userroles);
		this.ngoregistrationnumber=registrationnumber;
		this.ngoregdate=ngoregdate;
		// TODO Auto-generated constructor stub
	}

	
	public NGO() {
	}
	
	
	/**
	 * @return the ngoregistrationnumber
	 */
	public String getNgoregistrationnumber() {
		return ngoregistrationnumber;
	}
	/**
	 * @param ngoregistrationnumber the ngoregistrationnumber to set
	 */
	public void setNgoregistrationnumber(String ngoregistrationnumber) {
		this.ngoregistrationnumber = ngoregistrationnumber;
	}
	/**
	 * @return the ngoregdate
	 */
	public String getNgoregdate() {
		return ngoregdate;
	}
	/**
	 * @param ngoregdate the ngoregdate to set
	 */
	public void setNgoregdate(String ngoregdate) {
		this.ngoregdate = ngoregdate;
	}
	
	
	

	

}
