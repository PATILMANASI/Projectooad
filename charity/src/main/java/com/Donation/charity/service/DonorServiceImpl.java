package com.Donation.charity.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.UserRole;
import com.Donation.charity.repository.RepositoryService;
import com.Donation.charity.entities.Donor;

@Service
public class DonorServiceImpl implements DonorService{
	@Autowired
	private RepositoryService donorrepo;
	
	public DonorServiceImpl(RepositoryService donorrepo) {
		super();
		this.donorrepo = donorrepo;
	}
	
	@Autowired
	@Lazy
    private BCryptPasswordEncoder passwordEncoder;
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	
	
	/*public DonorServiceImpl(RepositoryService donorrepo) {
		super();
		this.donorrepo = donorrepo;
	}*/
	
/*	@Override
	public Donor save(Donor donoreg) {
		// TODO Auto-generated method stub
		
		Donor donor=new Donor(donoreg.getDrname(),donoreg.getDremail(),donoreg.getDrpassword(),donoreg.getDrcity(),donoreg.getDrphone(),donoreg.getDrpincode(),donoreg.getDradreess());
		return donorrepo.save(donor);
		
	}
*/
	/*@Override
	public List<Donor> getDonors() {
		// TODO Auto-generated method stub
		return donorrepo.findAll();
	}
	@Override
	public Donor addDonor(Donor donor) {
		// TODO Auto-generated method stub
		//list.add(user);
		donorrepo.save(donor);
		return donor;
	}*/
	@Override
	public Donor save(Donor donorreg) {
		Donor donor=new Donor(donorreg.getDrname(),donorreg.getDremail(),passwordEncoder.encode(donorreg.getDrpassword()),donorreg.getDrrepass(),donorreg.getDrcity(),donorreg.getDrphone(),donorreg.getDrpincode(),donorreg.getdraddress(),Arrays.asList(new UserRole("ROLE USER")));
		return donorrepo.save(donor);
	}


	@Override
	public List<Donor> getAllDonors() {
		// TODO Auto-generated method stub
		//return donorrepo.findAll();
//		String name="Bhavesh";
		return donorrepo.findByDrname(name);
		
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

	

    


	
}
