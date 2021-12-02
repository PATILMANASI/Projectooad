package com.Donation.charity.service;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.DA;
import com.Donation.charity.entities.DARole;

import com.Donation.charity.repository.DARepositoryService;


@Service
public class DAServiceImpl implements DAService {
	@Autowired
	private DARepositoryService darepo;
	
	@Autowired
	@Lazy
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DA da = darepo.findByDaemail(username);
        if (da == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
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
	public List<DA> getAllDAs() {
		String name="NotVerified";
		return darepo.findByDaregstatus(name);}
		
		@Override
		public DA saveDADetails(DA dareg) {
			DA da=new DA(dareg.getDaregstatus(),dareg.getDaname(),dareg.getDaregistrationnumber(),dareg.getDaregdate(),dareg.getDaemail(),passwordEncoder.encode(dareg.getDapassword()),dareg.getDarepassword(),dareg.getDaphone(),dareg.getDacity(),dareg.getDapincode(),dareg.getDaaddress(),Arrays.asList(new DARole("USER")));
			return darepo.save(da);
		}

		

		@Override
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
			
		}
}