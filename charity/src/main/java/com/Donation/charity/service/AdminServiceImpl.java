package com.Donation.charity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Admin;
import com.Donation.charity.entities.DA;
import com.Donation.charity.entities.Feedback;
import com.Donation.charity.entities.NGO;
import com.Donation.charity.entities.RegistrationStatus;
import com.Donation.charity.repository.AdminRepositoryService;
import com.Donation.charity.repository.CompleteDonationDetailsRepository;
import com.Donation.charity.repository.DARepositoryService;
import com.Donation.charity.repository.DonationRepositoryService;
import com.Donation.charity.repository.FeedbackRepositoryService;
import com.Donation.charity.repository.NGORepositoryService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepositoryService adrepo;
	
	@Autowired
	private NGORepositoryService ngorepo;
	
	@Autowired
	private DARepositoryService darepo;
	
	@Autowired
	private FeedbackRepositoryService feedbackrepo;
	
	@Autowired
	private DonationRepositoryService donationrepo;
	
	@Autowired
	private CompleteDonationDetailsRepository repo;
	@Override
	public Admin login(String adname, String adpassword) {
		  Admin admin = adrepo.findByUsernameAndPassword(adname, adpassword);
		   return admin;
		  }
	@Override
	public List<NGO> getAllNGOs() {
		
		return ngorepo.findByRegistrationstatus(RegistrationStatus.Not_Verified);
		
	}

	@Override
	public void markNGOVerified(int id) {
		// TODO Auto-generated method stub
		Optional<NGO> optional = ngorepo.findById( id);
		NGO ngo=null;
		if (optional.isPresent()) {
			ngo = optional.get();
		}
		ngo.setRegistrationstatus(RegistrationStatus.Verified);
		
		 ngorepo.save(ngo);
		
	}
	
	@Override
	public List<DA> getAllDAs() {
		
		return darepo.findByRegistrationstatus(RegistrationStatus.Not_Verified);
		}
	
	@Override
	public void MarkDAVerified(int id) {
		// TODO Auto-generated method stub
		Optional<DA> optional = darepo.findById( id);
		DA da=null;
		if (optional.isPresent()) {
			da = optional.get();
		}
		da.setRegistrationstatus(RegistrationStatus.Verified);
		 darepo.save(da);
		
	}
	@Override
	public List<Feedback> showAllFeedbacks() {
		return feedbackrepo.findAll();
	}
	@Override
	public void markNGORejected(int id) {
		// TODO Auto-generated method stub
		Optional<NGO> optional = ngorepo.findById( id);
		NGO ngo=null;
		if (optional.isPresent()) {
			ngo = optional.get();
		}
		ngo.setRegistrationstatus(RegistrationStatus.Rejected);
		
		 ngorepo.save(ngo);
		
	}
	@Override
	public void MarkDARejected(int id) {
		// TODO Auto-generated method stub
		Optional<DA> optional = darepo.findById( id);
		DA da=null;
		if (optional.isPresent()) {
			da = optional.get();
		}
		da.setRegistrationstatus(RegistrationStatus.Rejected);
		 darepo.save(da);
		
	}


}
