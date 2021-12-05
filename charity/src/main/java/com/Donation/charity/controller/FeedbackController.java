package com.Donation.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Donation.charity.entities.Feedback;
import com.Donation.charity.service.feedbackservice;



@Controller
@RequestMapping("/feedbackform")

/*@RequestMapping(value = "/", method = RequestMethod.GET) 
public String displayLogin(Feedback feedback) { 
    model.addAttribute("feedback", new Feedback()); 
    return "feedback"; 
}*/

public class FeedbackController {
	private feedbackservice feedbackservice;

	public FeedbackController(feedbackservice feedbackservice) {
		super();
		this.feedbackservice = feedbackservice;
	}
	
	@ModelAttribute("feedback")
	public Feedback feedbackreg() {
		return new Feedback();
		
	}
	
	@GetMapping
	public String showFeedbackForm() {
		return "feedback";
	}
	
	@PostMapping
	public String registerFeedbackAC(@ModelAttribute("feedbackobj") Feedback feedbackreg) {
		feedbackservice.save(feedbackreg);
		
		return "redirect:/feedbackform?success"; 
}
	
	

}
