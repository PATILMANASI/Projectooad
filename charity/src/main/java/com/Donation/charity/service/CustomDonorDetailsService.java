/*package com.Donation.charity.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.Donor;
import com.Donation.charity.repository.RepositoryService;

public class CustomDonorDetailsService implements UserDetailsService{
	
	@Autowired
	private DonorService donorservice;
	


    public CustomDonorDetails loadUserByUsername(String name) throws UsernameNotFoundException, DataAccessException {
        // returns the get(0) of the user list obtained from the db
        Donor domainUser = donorservice.getDonor(name);


        

        CustomDonorDetails customUserDetail=new CustomDonorDetails();
        customUserDetail.setDonor(domainUser);
        

        return customDonorDetails;

	

	
	
	


}*/
