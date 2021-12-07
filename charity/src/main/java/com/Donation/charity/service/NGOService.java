package com.Donation.charity.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.NGO;

public interface NGOService extends UserDetailsService{

	NGO saveNGODetails(NGO ngoreg);
	
	//public List<NGO> getAllNGOs();

	

	//void MarkVerified(int id);

	public List<CompleteDonationDetails> getAllDonations();

	void bookDonation(int id);
}
