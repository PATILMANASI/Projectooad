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
@Table(name="ProjectDonorsNew_12",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	private String email;
	private String password;
	private String repassword;
	private String city;
	private String phonenumber;
	private String pincode;
	private String address;
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "donors_roles_new_",
	        joinColumns = @JoinColumn(
	            name = "donors_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(
	            name = "roles_id", referencedColumnName = "id"))
	
	 private Collection < UserRole > userroles;
	 
	

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinColumn(name = "donor_id", referencedColumnName = "id")
	 private Set<Donation> donations=new HashSet<>();
	 
	 
	
	
public Donor() {
		
	}
	
	public Donor(String name, String email, String password,String repassword, String city, String phonenumber, String pincode,
			String address, Collection < UserRole > userroles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.repassword=repassword;
		this.city = city;
		this.phonenumber = phonenumber;
		this.pincode = pincode;
		this.address = address;
		this.userroles=userroles;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection < UserRole > getUserroles() {
		return userroles;
	}

	public void setUserroles(Collection < UserRole > userroles) {
		this.userroles = userroles;
	}

	
	
	

}
