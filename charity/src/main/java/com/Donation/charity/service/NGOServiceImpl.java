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
import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.NGO;
import com.Donation.charity.entities.NGORole;
import com.Donation.charity.repository.CompleteDonationDetailsRepository;
import com.Donation.charity.repository.MakeDonationRepositoryService;
import com.Donation.charity.repository.NGORepositoryService;
@Service
public class NGOServiceImpl implements NGOService {
	@Autowired
	private NGORepositoryService ngorepo;
	
	@Autowired
	private MakeDonationRepositoryService donationrepo;
	
	@Autowired
	private CompleteDonationDetailsRepository repo;
	
	@Autowired
	@Lazy
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		NGO ngo = ngorepo.findByNgoemail(username);
        if (ngo == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
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
	public List<NGO> getAllNGOs() {
		String name="NotVerified";
		return ngorepo.findByNgoregstatus(name);
		
	}

	@Override
	public void MarkVerified(int id) {
		// TODO Auto-generated method stub
		Optional<NGO> optional = ngorepo.findById( id);
		NGO ngo=null;
		if (optional.isPresent()) {
			ngo = optional.get();
		}
		ngo.setNgoregstatus("Verified");
		
		//Donor newdonor=new Donor(donor.getDrname(),donor.getDremail(),passwordEncoder.encode(donor.getDrpassword()),donor.getDrrepass(),donor.getDrcity(),donor.getDrphone(),donor.getDrpincode(),donor.getdraddress(),Arrays.asList(new UserRole("ROLE USER")));
		 ngorepo.save(ngo);
		
	}

	@Override
	public List<CompleteDonationDetails> getAllDonations() {
		// TODO Auto-generated method stub
		String cityname="";
		
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		   UserDetails userPrincipal = (UserDetails)authentication.getPrincipal(); 
		   String ngoemail= userPrincipal.getUsername();
		
		NGO ngo  = ngorepo.findByNgoemail(ngoemail);
		cityname=ngo.getNgocity();
		}
		//CompleteDonationDetails obj=(CompleteDonationDetails) repo.findByCity(cityname);
		
		return repo.findByCityAndDonationstatus(cityname, "Not Booked");
		//return repo.findByCity(cityname);
		
		
	}

	@Override
	public void bookDonation(int id) {
		// TODO Auto-generated method stub
		Optional<CompleteDonationDetails> optional = repo.findById(id);
		CompleteDonationDetails cdetails=null;
		if (optional.isPresent()) {
			cdetails = optional.get();
		}
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		   UserDetails userPrincipal = (UserDetails)authentication.getPrincipal(); 
		   String ngoemail= userPrincipal.getUsername();
		   NGO ngo  = ngorepo.findByNgoemail(ngoemail);
		  
		   cdetails.setNgo_name(ngo.getNgoname());
		   cdetails.setNgo_id(ngo.getId());
		   cdetails.setNgo_address(ngo.getNgoaddress());
		   cdetails.setDonationstatus("Booked");
		   Optional<Donation> optional1=donationrepo.findById(cdetails.getDonation_id());
		   Donation d=null;
		   if (optional1.isPresent()) {
				d = optional1.get();
				d.setNgo_id(cdetails.getNgo_id());
			}
		   repo.save(cdetails);
	}
	}
}
