package com.Donation.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Admin;
import com.Donation.charity.repository.AdminRepositoryService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepositoryService adrepo;
	@Override
	public Admin login(String adname, String adpassword) {
		  Admin admin = adrepo.findByUsernameAndPassword(adname, adpassword);
		   return admin;
		  }

}
