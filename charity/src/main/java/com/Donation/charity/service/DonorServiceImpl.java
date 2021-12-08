package com.Donation.charity.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.DonationStatus;
import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.Feedback;
import com.Donation.charity.entities.UserRole;
import com.Donation.charity.repository.CompleteDonationDetailsRepository;
import com.Donation.charity.repository.DonationRepositoryService;
import com.Donation.charity.repository.DonorRepositoryService;
import com.Donation.charity.repository.FeedbackRepositoryService;

import com.Donation.charity.entities.Donor;

@Service
public class DonorServiceImpl implements DonorService{
	@Autowired
	private DonorRepositoryService donorrepo;
	
	@Autowired
	private DonationRepositoryService donationrepo;
	
	@Autowired
	private FeedbackRepositoryService feedbackrepo;
	
	public UserDetails getLoggedInUser() {
		UserDetails loggedInUser = null;	
		
	org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (!(auth instanceof AnonymousAuthenticationToken)) {
	    loggedInUser = (UserDetails)auth.getPrincipal(); 
	}
	return loggedInUser;
	
	}
	@Autowired
  private CompleteDonationDetailsRepository completerepo;
	
	public DonorServiceImpl(DonorRepositoryService donorrepo) {
		super();
		this.donorrepo = donorrepo;
	}
	
	@Autowired
	@Lazy
    private BCryptPasswordEncoder passwordEncoder;

	
	@Override
	public Donor saveDonorDetails(Donor donorreg) {
		Donor donor=new Donor(donorreg.getName(),donorreg.getEmail(),passwordEncoder.encode(donorreg.getPassword()),donorreg.getRepassword(),donorreg.getCity(),donorreg.getPhonenumber(),donorreg.getPincode(),donorreg.getAddress(),Arrays.asList(new UserRole("ROLE USER")));
		return donorrepo.save(donor);
	}


	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		 Donor donor = donorrepo.findByEmail(username);
	        if (donor == null) {
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	        return new org.springframework.security.core.userdetails.User(donor.getEmail(),
	            donor.getPassword(),
	            mapRolesToAuthorities(donor.getUserroles()));
	
	}
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> userroles) {
		// TODO Auto-generated method stub
		 return userroles.stream()
		            .map(role -> new SimpleGrantedAuthority(role.getUsername()))
		            .collect(Collectors.toList());
	}
	




	@Override
	public void placeDonation(Donation donation) {
		// TODO Auto-generated method stub
		String donoremail;
			   UserDetails obj = getLoggedInUser();
			   donoremail= obj.getUsername();
			
			Donor donor  = donorrepo.findByEmail(donoremail);
			
			donation.setDonor_id(donor.getId());
			donation.setCity(donor.getCity());
			
				 
			Donation donate=new Donation(donation.getDonor_id(),donation.getDescription(),donation.getOthercategory(),donation.getComment(),donation.getDonationcategory(),donation.getCity());
			
		    donationrepo.save(donate);
			
		    CompleteDonationDetails details=new CompleteDonationDetails(donate.getId(),donor.getId(), 0,  donation.getDescription(), donation.getDonationcategory(),donation.getOthercategory(),donation.getComment(), donor.getName(), "", donor.getAddress(),donor.getCity(),"",0,"",donor.getPhonenumber(),"",donate.getDonationstatus());
			completerepo.save(details) ;
			}
		
	




	@Override
	public void provideFeedback(Feedback feedbackreg) {
		// TODO Auto-generated method stub
		Feedback feedback1=new Feedback(feedbackreg.getName(),feedbackreg.getFdemail(),feedbackreg.getFdsubject(),feedbackreg.getFdmessage());
	 feedbackrepo.save(feedback1);
	}
	
	

    


	
}
