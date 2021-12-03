package com.Donation.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.feedback;
import com.Donation.charity.repository.FeedbackRepositoryService;
import com.Donation.charity.repository.MakeDonationRepositoryService;

@Service
public class FeedbackServiceImpl implements feedbackservice {
	@Autowired
	private FeedbackRepositoryService feedbackrepo;
	@Autowired
	private feedbackservice feedbackservice;
	
	@Override
	public feedback save(feedback feedback2) {
		
		feedback feedback1=new feedback(feedback2.getFdmessage(),feedback2.getFdemail(),feedback2.getFdsubject(),feedback2.getFdmessage());
		return feedbackrepo.save(feedback1);
	}
}
