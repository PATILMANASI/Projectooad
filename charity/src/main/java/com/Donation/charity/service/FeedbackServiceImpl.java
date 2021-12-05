package com.Donation.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.Feedback;
import com.Donation.charity.entities.Feedback;
import com.Donation.charity.repository.FeedbackRepositoryService;
import com.Donation.charity.repository.MakeDonationRepositoryService;

@Service
public class FeedbackServiceImpl implements feedbackservice {
	@Autowired
	private FeedbackRepositoryService feedbackrepo;
	@Autowired
	private feedbackservice feedbackservice ;
	
	@Override
	public Feedback save(Feedback feedbackreg) {
		
		Feedback feedback1=new Feedback(feedbackreg.getFdmessage(),feedbackreg.getFdemail(),feedbackreg.getFdsubject(),feedbackreg.getFdmessage());
		return feedbackrepo.save(feedback1);
	}
}
