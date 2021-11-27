package com.Donation.charity.service;



import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Donation.charity.entities.Donor;

import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.Donor;


public interface DonorService extends UserDetailsService{
	Donor save(Donor donorreg);
	//Donor save(Donor donoreg);
	//public Donor addDonor(Donor donor);
	//public List<Donor> getDonors();

}
