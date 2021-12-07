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
import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.Feedback;
import com.Donation.charity.entities.UserRole;
import com.Donation.charity.repository.CompleteDonationDetailsRepository;
import com.Donation.charity.repository.DonationRepositoryService;
import com.Donation.charity.repository.FeedbackRepositoryService;
import com.Donation.charity.repository.RepositoryService;
import com.Donation.charity.entities.Donor;

@Service
public class DonorServiceImpl implements DonorService{
	@Autowired
	private RepositoryService donorrepo;
	
	@Autowired
	private DonationRepositoryService donationrepo;
	
	@Autowired
	private FeedbackRepositoryService feedbackrepo;

	
	@Autowired
  private CompleteDonationDetailsRepository completerepo;
	
	public DonorServiceImpl(RepositoryService donorrepo) {
		super();
		this.donorrepo = donorrepo;
	}
	
	@Autowired
	@Lazy
    private BCryptPasswordEncoder passwordEncoder;

	
	@Override
	public Donor save(Donor donorreg) {
		Donor donor=new Donor(donorreg.getDrname(),donorreg.getDremail(),passwordEncoder.encode(donorreg.getDrpassword()),donorreg.getDrrepass(),donorreg.getDrcity(),donorreg.getDrphone(),donorreg.getDrpincode(),donorreg.getdraddress(),Arrays.asList(new UserRole("ROLE USER")));
		return donorrepo.save(donor);
	}


	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		 Donor donor = donorrepo.findByDremail(username);
	        if (donor == null) {
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	        return new org.springframework.security.core.userdetails.User(donor.getDremail(),
	            donor.getDrpassword(),
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
		//	CustomDonorDetailsService principal = (CustomDonorDetailsService)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
			  // DonorDetails principal = (DonorDetails)
			  // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
			   UserDetails userPrincipal = (UserDetails)authentication.getPrincipal(); 
			
			   donoremail= userPrincipal.getUsername();
			
			Donor donor  = donorrepo.findByDremail(donoremail);
//			Donor donor=null;
			
			donation.setDonor_id(donor.getId());
			donation.setCity(donor.getDrcity());
			
				 
			Donation donate=new Donation(donation.getDonor_id(),donation.getDescription(),donation.getOthercategory(),donation.getComment(),donation.getDonationcategory(),donation.getCity());
			
		    donationrepo.save(donate);
			
		    CompleteDonationDetails details=new CompleteDonationDetails(donate.getId(),donor.getId(), 0,  donation.getDescription(), donation.getDonationcategory(),donation.getOthercategory(),donation.getComment(), donor.getDrname(), "", donor.getdraddress(),donor.getDrcity(),"",0,"",donor.getDrphone(),"");
			completerepo.save(details) ;
			}
		
	}




	@Override
	public void provideFeedback(Feedback feedbackreg) {
		// TODO Auto-generated method stub
		Feedback feedback1=new Feedback(feedbackreg.getName(),feedbackreg.getFdemail(),feedbackreg.getFdsubject(),feedbackreg.getFdmessage());
	 feedbackrepo.save(feedback1);
	}
	
	

    


	
}
