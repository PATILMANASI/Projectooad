package com.Donation.charity.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.DonationStatus;
import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.NGO;
import com.Donation.charity.entities.NGORole;
import com.Donation.charity.entities.RegistrationStatus;
import com.Donation.charity.repository.CompleteDonationDetailsRepository;
import com.Donation.charity.repository.DonationRepositoryService;

import com.Donation.charity.repository.NGORepositoryService;
@Service
public class NGOServiceImpl implements NGOService {
	@Autowired
	private NGORepositoryService ngorepo;
	
	@Autowired
	private DonationRepositoryService donationrepo;
	
	@Autowired 
	private DonorService donorservice;
	
	@Autowired
	private CompleteDonationDetailsRepository repo;
	
	@Autowired
	@Lazy
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username)  {
		NGO ngo = ngorepo.findByNgoemail(username);
       if (ngo == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        if((ngo.getRegistrationstatus()).equals(RegistrationStatus.Not_Verified)) {
        	throw new UsernameNotFoundException("Not verified.");
        }
        else 
        return new org.springframework.security.core.userdetails.User(ngo.getNgoemail(),
            ngo.getNgopassword(),
            mapRolesToAuthorities(ngo.getNgoroles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<NGORole> ngoroles) {
		 return ngoroles.stream()
		            .map(role -> new SimpleGrantedAuthority(role.getUsername()))
		            .collect(Collectors.toList());
	}

	@Override
	public NGO saveNGODetails(NGO ngoreg) {
		NGO ngo=new NGO(ngoreg.getNgoname(),ngoreg.getNgoregistrationnumber(),ngoreg.getNgoregdate(),ngoreg.getNgoemail(),passwordEncoder.encode(ngoreg.getNgopassword()),ngoreg.getNgorepassword(),ngoreg.getNgophone(),ngoreg.getNgocity(),ngoreg.getNgopincode(),ngoreg.getNgoaddress(),Arrays.asList(new NGORole("USER")));
		return ngorepo.save(ngo);
	}


	

	@Override
	public List<CompleteDonationDetails> getAllDonations() {
		// TODO Auto-generated method stub
		String cityname="";
		UserDetails obj = donorservice.getLoggedInUser();
		   String ngoemail= obj.getUsername();
		
		NGO ngo  = ngorepo.findByNgoemail(ngoemail);
		cityname=ngo.getNgocity();
		
		return repo.findByCityAndDonationstatus(cityname,DonationStatus.Not_Booked);
		
		
	}

	@Override
	public void bookDonation(int id) {
		// TODO Auto-generated method stub
		Optional<CompleteDonationDetails> optional = repo.findById(id);
		CompleteDonationDetails cdetails=null;
		if (optional.isPresent()) {
			cdetails = optional.get();
		}
		UserDetails obj = donorservice.getLoggedInUser();
		   String ngoemail= obj.getUsername();
		   NGO ngo  = ngorepo.findByNgoemail(ngoemail);
		  
		   cdetails.setNgo_name(ngo.getNgoname());
		   cdetails.setNgo_id(ngo.getId());
		   cdetails.setNgo_phoneno(ngo.getNgophone());
		   cdetails.setNgo_address(ngo.getNgoaddress());
		   cdetails.setDonationstatus(DonationStatus.Booked);
		   Optional<Donation> optional1=donationrepo.findById(cdetails.getDonation_id());
		   Donation d=null;
		   if (optional1.isPresent()) {
				d = optional1.get();
				d.setNgo_id(cdetails.getNgo_id());
			}
		   repo.save(cdetails);
	}
	}

	

