package com.Donation.charity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Donor;
import com.Donation.charity.repository.RepositoryService;
import com.Donation.charity.entities.Donor;

@Service
public class DonorServiceImpl implements DonorService{
	@Autowired
	private RepositoryService donorrepo;
	
	public DonorServiceImpl(RepositoryService donorrepo) {
		super();
		this.donorrepo = donorrepo;
	}
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	
	
	/*public DonorServiceImpl(RepositoryService donorrepo) {
		super();
		this.donorrepo = donorrepo;
	}*/
	
/*	@Override
	public Donor save(Donor donoreg) {
		// TODO Auto-generated method stub
		
		Donor donor=new Donor(donoreg.getDrname(),donoreg.getDremail(),donoreg.getDrpassword(),donoreg.getDrcity(),donoreg.getDrphone(),donoreg.getDrpincode(),donoreg.getDradreess());
		return donorrepo.save(donor);
		
	}
*/
	/*@Override
	public List<Donor> getDonors() {
		// TODO Auto-generated method stub
		return donorrepo.findAll();
	}
	@Override
	public Donor addDonor(Donor donor) {
		// TODO Auto-generated method stub
		//list.add(user);
		donorrepo.save(donor);
		return donor;
	}*/
	@Override
	public Donor save(Donor donorreg) {
		Donor donor=new Donor(donorreg.getDrname(),donorreg.getDremail(),donorreg.getDrpassword(),donorreg.getDrrepass(),donorreg.getDrcity(),donorreg.getDrphone(),donorreg.getDrpincode(),donorreg.getdraddress());
		return donorrepo.save(donor);
	}


	
}
