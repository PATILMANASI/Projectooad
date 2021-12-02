package com.Donation.charity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.NGO;
import com.Donation.charity.repository.MakeDonationRepositoryService;
import com.Donation.charity.repository.RepositoryService;
@Service
public class MakeDonationServiceImpl implements MakeDonationService{
	@Autowired
	private MakeDonationRepositoryService makedonationrepo;
	@Autowired
	private RepositoryService donorrepo;

	@Override
	public Donation save(Donation donation) {
		String donoremail;
	//	CustomDonorDetailsService principal = (CustomDonorDetailsService)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		  // DonorDetails principal = (DonorDetails)
		  // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		   UserDetails userPrincipal = (UserDetails)authentication.getPrincipal(); 
		   donoremail= userPrincipal.getUsername();
		
		Donor donor  = donorrepo.findByDremail(donoremail);
//		Donor donor=null;
		
		donation.setDonor_id(donor.getId());
		donation.setCity(donor.getDrcity());
		}	    
			 
		Donation donate=new Donation(donation.getDonor_id(),donation.getDescription(),donation.getOthercategory(),donation.getComment(),donation.getDonationcategory(),donation.getCity());
		
		
		return makedonationrepo.save(donate);
	}

}
