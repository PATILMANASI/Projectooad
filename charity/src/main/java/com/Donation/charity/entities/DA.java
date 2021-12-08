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
@Table(name="Project_DAs_new_12",uniqueConstraints = @UniqueConstraint(columnNames = "daemail"))
public class DA {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private RegistrationStatus registrationstatus=RegistrationStatus.Not_Verified;
	private String daname;
	private String daemail;
	private String dapassword;
	private String darepassword;
	private String daphone;
	private String dacity;
	private String dapincode;
	private String daaddress;
	
	

	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "DA_roles_new",
	        joinColumns = @JoinColumn(
	            name = "da_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(
	            name = "role_id", referencedColumnName = "id"))
	
	 private Collection < DARole > daroles;
	
	

	public DA() {
		
	}
	public DA(RegistrationStatus registrationstatus, String daname, String daemail,
			String dapassword, String darepassword, String daphone, String dacity, String dapincode, String daaddress,
			Collection<DARole> daroles) {
		super();
		this.registrationstatus=registrationstatus;
		this.daname = daname;
		
		this.daemail = daemail;
		this.dapassword = dapassword;
		this.darepassword = darepassword;
		this.daphone = daphone;
		this.dacity = dacity;
		this.dapincode = dapincode;
		this.daaddress = daaddress;
		this.daroles = daroles;
	}

	
	

	
	public RegistrationStatus getRegistrationstatus() {
		return registrationstatus;
	}
	public void setRegistrationstatus(RegistrationStatus registrationstatus) {
		this.registrationstatus = registrationstatus;
	}
	public String getDaname() {
		return daname;
	}
	public void setDaname(String daname) {
		this.daname = daname;
	}

	public String getDaemail() {
		return daemail;
	}
	public void setDaemail(String daemail) {
		this.daemail = daemail;
	}
	public String getDapassword() {
		return dapassword;
	}
	public void setDapassword(String dapassword) {
		this.dapassword = dapassword;
	}
	public String getDarepassword() {
		return darepassword;
	}
	public void setDarepassword(String darepassword) {
		this.darepassword = darepassword;
	}
	public String getDaphone() {
		return daphone;
	}
	public void setDaphone(String daphone) {
		this.daphone = daphone;
	}
	public String getDacity() {
		return dacity;
	}
	public void setDacity(String dacity) {
		this.dacity = dacity;
	}
	public String getDapincode() {
		return dapincode;
	}
	public void setDapincode(String dapincode) {
		this.dapincode = dapincode;
	}
	public String getDaaddress() {
		return daaddress;
	}
	public void setDaaddress(String daaddress) {
		this.daaddress = daaddress;
	}
	public Collection<DARole> getDaroles() {
		return daroles;
	}
	public void setDaroles(Collection<DARole> daroles) {
		this.daroles = daroles;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
