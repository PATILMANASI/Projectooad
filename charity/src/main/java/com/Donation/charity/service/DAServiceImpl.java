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
import com.Donation.charity.entities.NGO;
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
	@Lazy
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DA da = darepo.findByDaemail(username);
        if (da == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        if((da.getDaregstatus()).equals("NotVerified")) {
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

	
	/*@Override
	public List<DA> getAllDAs() {
		String name="NotVerified";
		return darepo.findByDaregstatus(name);}*/
		
		@Override
		public DA saveDADetails(DA dareg) {
			DA da=new DA(dareg.getDaregstatus(),dareg.getDaname(),dareg.getDaregistrationnumber(),dareg.getDaregdate(),dareg.getDaemail(),passwordEncoder.encode(dareg.getDapassword()),dareg.getDarepassword(),dareg.getDaphone(),dareg.getDacity(),dareg.getDapincode(),dareg.getDaaddress(),Arrays.asList(new DARole("USER")));
			return darepo.save(da);
		}

		

	/*	@Override
		public void MarkVerified(int id) {
			// TODO Auto-generated method stub
			Optional<DA> optional = darepo.findById( id);
			DA da=null;
			if (optional.isPresent()) {
				da = optional.get();
			}
			da.setDaregstatus("Verified");
			
			//Donor newdonor=new Donor(donor.getDrname(),donor.getDremail(),passwordEncoder.encode(donor.getDrpassword()),donor.getDrrepass(),donor.getDrcity(),donor.getDrphone(),donor.getDrpincode(),donor.getdraddress(),Arrays.asList(new UserRole("ROLE USER")));
			 darepo.save(da);
			
		}*/

		@Override
		public List<CompleteDonationDetails> getAllOrders() {
			// TODO Auto-generated method stub
			String cityname="";
			
			org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
			   UserDetails userPrincipal = (UserDetails)authentication.getPrincipal(); 
			   String daemail= userPrincipal.getUsername();
			
			DA da  = darepo.findByDaemail(daemail);
			cityname=da.getDacity();
			}
			//CompleteDonationDetails obj=(CompleteDonationDetails) repo.findByCity(cityname);
			
			return repo.findByCityAndDonationstatus(cityname, "Booked");
			
		}

		@Override
		public void bookOrder(int id) {
			// TODO Auto-generated method stub
			Optional<CompleteDonationDetails> optional = repo.findById(id);
			CompleteDonationDetails cdetails=null;
			if (optional.isPresent()) {
				cdetails = optional.get();
			}
			org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
			   UserDetails userPrincipal = (UserDetails)authentication.getPrincipal(); 
			   String daemail= userPrincipal.getUsername();
			   DA da  = darepo.findByDaemail(daemail);
			  
			   cdetails.setDa_name(da.getDaname());
			   cdetails.setDaid(da.getId());
			   cdetails.setDonationstatus("Order Accepted");
			   Optional<Donation> optional1=donationrepo.findById(cdetails.getDonation_id());
			   Donation d=null;
			   if (optional1.isPresent()) {
					d = optional1.get();
					d.setDa_id(cdetails.getDaid());
				}
			   repo.save(cdetails);
		}
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
			//CompleteDonationDetails obj=(CompleteDonationDetails) repo.findByCity(cityname);
			// CompleteDonationDetailsRepository temp=repo.findByDaid(da_id);
			return repo.findByDaidAndDonationstatusOrDonationstatus(da_id, "Order Accepted","Picked up");
		}

		@Override
		public void updateOrderStatusPickedUp(int id) {
			// TODO Auto-generated method stub// TODO Auto-generated method stub
			Optional<CompleteDonationDetails> optional = repo.findById(id);
			CompleteDonationDetails cdetails=null;
			if (optional.isPresent()) {
				cdetails = optional.get();
			}
			org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
			   UserDetails userPrincipal = (UserDetails)authentication.getPrincipal(); 
			   String daemail= userPrincipal.getUsername();
			   DA da  = darepo.findByDaemail(daemail);
			  
			  
			   cdetails.setDonationstatus("Picked up");
			  
		}
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
			org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
			   UserDetails userPrincipal = (UserDetails)authentication.getPrincipal(); 
			   String daemail= userPrincipal.getUsername();
			   DA da  = darepo.findByDaemail(daemail);
			  
			  
			   cdetails.setDonationstatus("Delivered");
			  
		}
			   repo.save(cdetails);
			
		}
			
		}
			
		
