package com.Donation.charity.entities;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="Donor")
public class Donor extends User {

	
public Donor( String name, String email, String password, String repassword, String city, String phonenumber,
			String pincode, String address, Collection<UserRole> userroles) {
		super( name, email, password, repassword, city, phonenumber, pincode, address, userroles);
		// TODO Auto-generated constructor stub
	}
public Donor() {
	
}
	
	


}
