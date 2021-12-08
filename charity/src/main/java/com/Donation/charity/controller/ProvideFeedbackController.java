package com.Donation.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Donation.charity.entities.Feedback;
import com.Donation.charity.service.DonorService;




@Controller
@RequestMapping("/feedbackform")
public class ProvideFeedbackController {
	@Autowired
	private DonorService donorservice;

	public ProvideFeedbackController(DonorService donorservice) {
		super();
		this.donorservice = donorservice;
	}
	
	@ModelAttribute("feedbackobj")
	public Feedback feedbackreg() {
		return new Feedback();
		
	}
	
	@GetMapping
	public String showFeedbackForm() {
		return "feedback";
	}
	
	@PostMapping
	public String registerFeedbackAC(@ModelAttribute("feedbackobj") Feedback feedbackreg) {
		donorservice.provideFeedback(feedbackreg);
		
		return "redirect:/feedbackform?success"; 
}
	
	

}
