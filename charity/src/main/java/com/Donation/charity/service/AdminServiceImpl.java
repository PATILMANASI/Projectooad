package com.Donation.charity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Admin;
import com.Donation.charity.entities.DA;
import com.Donation.charity.entities.Feedback;
import com.Donation.charity.entities.NGO;
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
		String name="NotVerified";
		return ngorepo.findByNgoregstatus(name);
		
	}

	@Override
	public void markNGOVerified(int id) {
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
	public List<DA> getAllDAs() {
		String name="NotVerified";
		return darepo.findByDaregstatus(name);
		}
	
	@Override
	public void MarkDAVerified(int id) {
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
	@Override
	public List<Feedback> showAllFeedbacks() {
		// TODO Auto-generated method stub
		return feedbackrepo.findAll();
	}


}
