package com.Donation.charity.service;



import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.Feedback;
import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.Donor;


public interface DonorService extends UserDetailsService{
	Donor save(Donor donorreg);

	void placeDonation(Donation donation);

	void provideFeedback(Feedback feedbackreg);


}
