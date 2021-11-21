package com.Donation.charity.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="ProjectDonors",uniqueConstraints = @UniqueConstraint(columnNames = "dremail"))
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long donorid;
	
	private String drname;
	private String dremail;
	private String drpassword;
	private String drrepass;
	private String drcity;
	private String drphone;
	private String drpincode;
	private String draddress;
	
public Donor() {
		
	}
	
	public Donor(String drname, String dremail, String drpassword,String drrepass, String drcity, String drphone, String drpincode,
			String draddress) {
		super();
		this.drname = drname;
		this.dremail = dremail;
		this.drpassword = drpassword;
		this.drrepass=drrepass;
		this.drcity = drcity;
		this.drphone = drphone;
		this.drpincode = drpincode;
		this.draddress = draddress;
	}
	
	public String getDrname() {
		return drname;
	}

	public void setDrname(String drname) {
		this.drname = drname;
	}

	public String getDremail() {
		return dremail;
	}

	public void setDremail(String dremail) {
		this.dremail = dremail;
	}

	public String getDrpassword() {
		return drpassword;
	}

	public void setDrpassword(String drpassword) {
		this.drpassword = drpassword;
	}

	public String getDrcity() {
		return drcity;
	}

	public void setDrcity(String drcity) {
		this.drcity = drcity;
	}

	public String getDrphone() {
		return drphone;
	}

	public void setDrphone(String drphone) {
		this.drphone = drphone;
	}

	public String getDrpincode() {
		return drpincode;
	}

	public void setDrpincode(String drpincode) {
		this.drpincode = drpincode;
	}

	public String getdraddress() {
		return draddress;
	}

	public void setdraddress(String draddress) {
		this.draddress = draddress;
	}

	public String getDrrepass() {
		return drrepass;
	}

	public void setDrrepass(String drrepass) {
		this.drrepass = drrepass;
	}

	
	
	

}
