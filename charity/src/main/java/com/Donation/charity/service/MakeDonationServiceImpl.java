package com.Donation.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.Donor;
import com.Donation.charity.repository.MakeDonationRepositoryService;
@Service
public class MakeDonationServiceImpl implements MakeDonationService{
	@Autowired
	private MakeDonationRepositoryService makedonationrepo;

	@Override
	public Donation save(Donation donation) {
		Donation donate=new Donation(donation.getDonationcategory(),donation.getOthercategory(),donation.getDescription(),donation.getComment());
		return makedonationrepo.save(donate);
	}

}
