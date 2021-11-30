package com.Donation.charity.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="Project_NGOs_new",uniqueConstraints = @UniqueConstraint(columnNames = "ngoemail"))
public class NGO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String ngoregstatus="NotVerified";
	private String ngoname;
	private String ngoregistrationnumber;
	private String ngoregdate;
	private String ngoemail;
	private String ngopassword;
	private String ngorepassword;
	private String ngophone;
	private String ngocity;
	private String ngopincode;
	private String ngoaddress;
	
	//@Column(columnDefinition = "varchar(255) default 'NotVerified'")

	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "NGO_roles_new",
	        joinColumns = @JoinColumn(
	            name = "ngo_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(
	            name = "role_id", referencedColumnName = "id"))
	
	 private Collection < NGORole > ngoroles;
	
	

	public NGO() {
		
	}
	
	public NGO(String ngoname, String ngoregistrationnumber, String ngoregdate, String ngoemail, String ngopassword,
			String ngorepassword, String ngophone, String ngocity, String ngopincode, String ngoaddress,Collection < NGORole > ngoroles) {
		super();
		this.ngoname = ngoname;
		this.ngoregistrationnumber = ngoregistrationnumber;
		this.ngoregdate = ngoregdate;
		this.ngoemail = ngoemail;
		this.ngopassword = ngopassword;
		this.ngorepassword = ngorepassword;
		this.ngophone = ngophone;
		this.ngocity = ngocity;
		this.ngopincode = ngopincode;
		this.ngoaddress = ngoaddress;
		this.ngoroles=ngoroles;
		
	}

	public String getNgoname() {
		return ngoname;
	}

	public void setNgoname(String ngoname) {
		this.ngoname = ngoname;
	}

	public String getNgoregistrationnumber() {
		return ngoregistrationnumber;
	}

	public void setNgoregistrationnumber(String ngoregistrationnumber) {
		this.ngoregistrationnumber = ngoregistrationnumber;
	}

	public String getNgoregdate() {
		return ngoregdate;
	}

	public void setNgoregdate(String ngoregdate) {
		this.ngoregdate = ngoregdate;
	}

	public String getNgoemail() {
		return ngoemail;
	}

	public void setNgoemail(String ngoemail) {
		this.ngoemail = ngoemail;
	}

	public String getNgopassword() {
		return ngopassword;
	}

	public void setNgopassword(String ngopassword) {
		this.ngopassword = ngopassword;
	}

	public String getNgorepassword() {
		return ngorepassword;
	}

	public void setNgorepassword(String ngorepassword) {
		this.ngorepassword = ngorepassword;
	}

	public String getNgophone() {
		return ngophone;
	}

	public void setNgophone(String ngophone) {
		this.ngophone = ngophone;
	}

	public String getNgocity() {
		return ngocity;
	}

	public void setNgocity(String ngocity) {
		this.ngocity = ngocity;
	}

	public String getNgopincode() {
		return ngopincode;
	}

	public void setNgopincode(String ngopincode) {
		this.ngopincode = ngopincode;
	}

	public String getNgoaddress() {
		return ngoaddress;
	}

	public void setNgoaddress(String ngoaddress) {
		this.ngoaddress = ngoaddress;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNgoregstatus() {
		return ngoregstatus;
	}

	public void setNgoregstatus(String ngoregstatus) {
		this.ngoregstatus = ngoregstatus;
	}
	
	public Collection<NGORole> getNgoroles() {
		return ngoroles;
	}

	public void setNgoroles(Collection<NGORole> ngoroles) {
		this.ngoroles = ngoroles;
	}


}
