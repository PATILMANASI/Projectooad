package com.Donation.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.feedback;
import com.Donation.charity.service.feedbackservice;



@Controller
@RequestMapping("/feedbackform")

public class FeedbackController {
	private feedbackservice feedbackservice;

	public FeedbackController(feedbackservice feedbackservice) {
		super();
		this.feedbackservice = feedbackservice;
	}
	
	@ModelAttribute("feedback")
	public feedback feedbackreg() {
		return new feedback();
		
	}
	
	@GetMapping
	public String showFeedbackForm() {
		return "feedback";
	}
	
	@PostMapping
	public String registerFeedbackAC(@ModelAttribute("feedback") feedback feedbackreg) {
		feedbackservice.save(feedbackreg);
		
		return "redirect:/feedbackform?success"; 
}
	
	

}
