package com.Donation.charity.service;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.entities.DA;
import com.Donation.charity.entities.DARole;
import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.DonationStatus;
import com.Donation.charity.entities.NGO;
import com.Donation.charity.entities.RegistrationStatus;
import com.Donation.charity.repository.CompleteDonationDetailsRepository;
import com.Donation.charity.repository.DARepositoryService;
import com.Donation.charity.repository.DonationRepositoryService;



@Service
public class DAServiceImpl implements DAService {
	@Autowired
	private DARepositoryService darepo;
	
	@Autowired
	private DonationRepositoryService donationrepo;
	
	@Autowired
	private CompleteDonationDetailsRepository repo;
	
	@Autowired 
	private DonorService donorservice;
	
	
	@Autowired
	@Lazy
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DA da = darepo.findByDaemail(username);
        if (da == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        if((da.getRegistrationstatus()).equals(RegistrationStatus.Not_Verified) ){
        	throw new UsernameNotFoundException("Not verified.");
        }
        return new org.springframework.security.core.userdetails.User(da.getDaemail(),
            da.getDapassword(),
            mapRolesToAuthorities(da.getDaroles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<DARole> daroles) {
		 return daroles.stream()
		            .map(role -> new SimpleGrantedAuthority(role.getUsername()))
		            .collect(Collectors.toList());
	}

	

		
		@Override
		public DA saveDADetails(DA dareg) {
			DA da=new DA(dareg.getRegistrationstatus(),dareg.getDaname(),dareg.getDaemail(),passwordEncoder.encode(dareg.getDapassword()),dareg.getDarepassword(),dareg.getDaphone(),dareg.getDacity(),dareg.getDapincode(),dareg.getDaaddress(),Arrays.asList(new DARole("USER")));
			return darepo.save(da);
		}

		

	
		@Override
		public List<CompleteDonationDetails> getAllOrders() {
			// TODO Auto-generated method stub
			String cityname="";
			UserDetails obj = donorservice.getLoggedInUser();
		
			   String daemail= obj.getUsername();
			
			DA da  = darepo.findByDaemail(daemail);
			cityname=da.getDacity();
			
		
			
			return repo.findByCityAndDonationstatus(cityname, com.Donation.charity.entities.DonationStatus.Booked);
			
		}

		@Override
		public void bookOrder(int id) {
			// TODO Auto-generated method stub
			Optional<CompleteDonationDetails> optional = repo.findById(id);
			CompleteDonationDetails cdetails=null;
			if (optional.isPresent()) {
				cdetails = optional.get();
			}
			UserDetails obj = donorservice.getLoggedInUser();
			   String daemail= obj.getUsername();
			   DA da  = darepo.findByDaemail(daemail);
			  
			   cdetails.setDa_name(da.getDaname());
			   cdetails.setDaid(da.getId());
			   cdetails.setDonationstatus(com.Donation.charity.entities.DonationStatus.Order_Accepted);
			   Optional<Donation> optional1=donationrepo.findById(cdetails.getDonation_id());
			   Donation d=null;
			   if (optional1.isPresent()) {
					d = optional1.get();
					d.setDa_id(cdetails.getDaid());
				}
			   repo.save(cdetails);
		}
		

		@Override
		public List<CompleteDonationDetails> getAllAcceptedOrders() {
			// TODO Auto-generated method stub
			int da_id=0;
			
			org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
			   UserDetails userPrincipal = (UserDetails)authentication.getPrincipal(); 
			   String daemail= userPrincipal.getUsername();
			
			DA da  = darepo.findByDaemail(daemail);
			da_id=da.getId();
			
			}
			return repo.findByDaidAndDonationstatusOrDonationstatus(da_id, DonationStatus.Order_Accepted,DonationStatus.Picked_up);
		}

		@Override
		public void updateOrderStatusPickedUp(int id) {
			// TODO Auto-generated method stub// TODO Auto-generated method stub
			Optional<CompleteDonationDetails> optional = repo.findById(id);
			CompleteDonationDetails cdetails=null;
			if (optional.isPresent()) {
				cdetails = optional.get();
			}
			UserDetails obj = donorservice.getLoggedInUser(); 
			   String daemail= obj.getUsername();
			   DA da  = darepo.findByDaemail(daemail);
			  
			  
			   cdetails.setDonationstatus(DonationStatus.Picked_up);
			  
		
			   repo.save(cdetails);
		}

		@Override
		public void updateOrderStatusDelivered(int id) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub// TODO Auto-generated method stub
			Optional<CompleteDonationDetails> optional = repo.findById(id);
			CompleteDonationDetails cdetails=null;
			if (optional.isPresent()) {
				cdetails = optional.get();
			}
			UserDetails obj = donorservice.getLoggedInUser();
			   String daemail= obj.getUsername();
			   DA da  = darepo.findByDaemail(daemail);
			  
			  
			   cdetails.setDonationstatus(DonationStatus.Delivered);
			  
		
			   repo.save(cdetails);
			
		}
			
		}
			
		
