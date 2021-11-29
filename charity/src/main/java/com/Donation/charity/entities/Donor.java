package com.Donation.charity.entities;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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



@Entity
@Table(name="ProjectDonorsNew",uniqueConstraints = @UniqueConstraint(columnNames = "dremail"))
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	

	private String drname;
	private String dremail;
	private String drpassword;
	private String drrepass;
	private String drcity;
	private String drphone;
	private String drpincode;
	private String draddress;
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "donors_roles_new",
	        joinColumns = @JoinColumn(
	            name = "donors_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(
	            name = "roles_id", referencedColumnName = "id"))
	
	 private Collection < UserRole > userroles;
	 
	

/*	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinColumn(name = "donor_fid", referencedColumnName = "id")
	 private Set<Donation> donations=new HashSet<>();*/
	 
	 
	
	
public Donor() {
		
	}
	
	public Donor(String drname, String dremail, String drpassword,String drrepass, String drcity, String drphone, String drpincode,
			String draddress, Collection < UserRole > userroles) {
		super();
		this.drname = drname;
		this.dremail = dremail;
		this.drpassword = drpassword;
		this.drrepass=drrepass;
		this.drcity = drcity;
		this.drphone = drphone;
		this.drpincode = drpincode;
		this.draddress = draddress;
		this.userroles=userroles;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Collection < UserRole > getUserroles() {
		return userroles;
	}

	public void setUserroles(Collection < UserRole > userroles) {
		this.userroles = userroles;
	}

	
	
	

}
