package com.Donation.charity.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class CompleteDonationDetails {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int donation_id;
	private int donor_id;
	private int ngo_id;
	private String description;
	@Enumerated(EnumType.STRING)
	private DonationCategory donationcategory;
	private String otherCategory;
	private String comment;
	private String donor_name;
	private String ngo_name;
	private String donor_address;
	private String ngo_address;
	private String donor_phoneno;
	private String ngo_phoneno;
	private String city;
	private String da_name;
	private int daid;
	private String donationstatus="Not Booked";
	
	public CompleteDonationDetails() {
		super();
	}
	public CompleteDonationDetails(int donation_id,int donor_id, int ngo_id, String description, DonationCategory donationcategory,
			String otherCategory, String comment, String donor_name, String ngo_name, String donor_address,String city,String da_name,int da_id,
			String ngo_address,String donor_phoneno,String ngo_phoneno) {
		super();
		this.donation_id=donation_id;
		this.donor_id = donor_id;
		this.ngo_id = ngo_id;
		this.description = description;
		this.donationcategory = donationcategory;
		this.otherCategory = otherCategory;
		this.comment = comment;
		this.donor_name = donor_name;
		this.ngo_name = ngo_name;
		this.donor_address = donor_address;
		this.ngo_address = ngo_address;
		this.city=city;
		this.daid=da_id;
		this.da_name=da_name;
		this.setDonor_phoneno(donor_phoneno);
		this.setNgo_phoneno(ngo_phoneno);
	}
	public int getDonor_id() {
		return donor_id;
	}
	public void setDonor_id(int donor_id) {
		this.donor_id = donor_id;
	}
	public int getNgo_id() {
		return ngo_id;
	}
	public void setNgo_id(int ngo_id) {
		this.ngo_id = ngo_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public DonationCategory getDonationcategory() {
		return donationcategory;
	}
	public void setDonationcategory(DonationCategory donationcategory) {
		this.donationcategory = donationcategory;
	}
	public String getOtherCategory() {
		return otherCategory;
	}
	public void setOtherCategory(String otherCategory) {
		this.otherCategory = otherCategory;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDonor_name() {
		return donor_name;
	}
	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}
	public String getNgo_name() {
		return ngo_name;
	}
	public void setNgo_name(String ngo_name) {
		this.ngo_name = ngo_name;
	}
	public String getDonor_address() {
		return donor_address;
	}
	public void setDonor_address(String donor_address) {
		this.donor_address = donor_address;
	}
	public String getNgo_address() {
		return ngo_address;
	}
	public void setNgo_address(String ngo_address) {
		this.ngo_address = ngo_address;
	}
	/**
	 * @return the donation_id
	 */
	public int getDonation_id() {
		return donation_id;
	}
	/**
	 * @param donation_id the donation_id to set
	 */
	public void setDonation_id(int donation_id) {
		this.donation_id = donation_id;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the donation_status
	 */
	public String getDonationstatus() {
		return donationstatus;
	}
	/**
	 * @param donation_status the donation_status to set
	 */
	public void setDonationstatus(String donation_status) {
		this.donationstatus = donation_status;
	}
	/**
	 * @return the da_name
	 */
	public String getDa_name() {
		return da_name;
	}
	/**
	 * @param da_name the da_name to set
	 */
	public void setDa_name(String da_name) {
		this.da_name = da_name;
	}
	/**
	 * @return the da_id
	 */
	
	/**
	 * @return the daid
	 */
	public int getDaid() {
		return daid;
	}
	/**
	 * @param daid the daid to set
	 */
	public void setDaid(int daid) {
		this.daid = daid;
	}
	/**
	 * @return the donor_phoneno
	 */
	public String getDonor_phoneno() {
		return donor_phoneno;
	}
	/**
	 * @param donor_phoneno the donor_phoneno to set
	 */
	public void setDonor_phoneno(String donor_phoneno) {
		this.donor_phoneno = donor_phoneno;
	}
	/**
	 * @return the ngo_phoneno
	 */
	public String getNgo_phoneno() {
		return ngo_phoneno;
	}
	/**
	 * @param ngo_phoneno the ngo_phoneno to set
	 */
	public void setNgo_phoneno(String ngo_phoneno) {
		this.ngo_phoneno = ngo_phoneno;
	}
	
	
	

}
