package com.Donation.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.Donor;

import com.Donation.charity.repository.MakeDonationRepositoryService;
@Service
public class MakeDonationServiceImpl implements MakeDonationService{
	@Autowired
	private MakeDonationRepositoryService makedonationrepo;
	@Autowired
	private DonorService donorservice;

	@Override
	public Donation save(Donation donation) {
	//	CustomDonorDetailsService principal = (CustomDonorDetailsService)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		  // DonorDetails principal = (DonorDetails)
		  // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			    
			 
		Donation donate=new Donation(donation.getDonor_id(),donation.getDescription(),donation.getOthercategory(),donation.getComment(),donation.getDonationcategory());
		return makedonationrepo.save(donate);
	}

}
