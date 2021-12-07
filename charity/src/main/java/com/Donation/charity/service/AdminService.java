package com.Donation.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Admin;
import com.Donation.charity.repository.AdminRepositoryService;

/*package com.Donation.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Admin;
import com.Donation.charity.repository.AdminRepositoryService;
/*@Service
public class AdminService implements UserDetailsService{
	@Autowired
	private AdminRepositoryService adminrepo;

	@Override
	public UserDetails loadUserByUsername(String adname) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Admin admin=adminrepo.findByAdname(adname);
		if(admin==null) {
			throw new UsernameNotFoundException("Admin not found");
		}
		else {
		  return new CustomAdminDetails(admin);
	}
	}

}*/

public interface AdminService {

  
  public Admin login(String adname, String adpassword);
  
}