package com.Donation.charity.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Donation.charity.entities.DA;

public interface DAService extends UserDetailsService {
	
	DA saveDADetails(DA dareg);
	
	public List<DA> getAllDAs();
	

	void MarkVerified(int id);

}
