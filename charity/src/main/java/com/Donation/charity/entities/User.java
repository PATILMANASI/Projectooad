package com.Donation.charity.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="USERTABLE",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	public User() {
		
	}
	public User( String name, String email, String password, String repassword, String city, String phonenumber,
			String pincode, String address, Collection<UserRole> userroles) {
		super();
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.repassword = repassword;
		this.city = city;
		this.phonenumber = phonenumber;
		this.pincode = pincode;
		this.address = address;
		this.userroles = userroles;
		this.donations = donations;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected int id;
	
	
	protected String name;
	protected String email;
	protected String password;
	protected String repassword;
	protected String city;
	protected String phonenumber;
	protected String pincode;
	protected String address;
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "donors_roles_new_1",
	        joinColumns = @JoinColumn(
	            name = "donors_id_1", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(
	            name = "roles_id_1", referencedColumnName = "id"))
	
	 protected Collection < UserRole > userroles;
	 
	

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinColumn(name = "donor_id", referencedColumnName = "id")
	protected Set<Donation> donations=new HashSet<>();
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
