package com.Donation.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.DonationCategory;
import com.Donation.charity.entities.Donor;
import com.Donation.charity.service.DonorService;

@Controller
@RequestMapping("/makedonation")
public class MakeDonationController {
	
	@Autowired
	private DonorService donorservice;

	
    public MakeDonationController(DonorService donorservice) {
		super();
		this.donorservice = donorservice;
	}

	@ModelAttribute("donate")
	public Donation donorreg1() {
		return new Donation();
	}
    
    @GetMapping
	public String showDonation(Donation donate,Model model) {
    	donate.getDonationcategory();
    	model.addAttribute("categoryname",DonationCategory.values());
		return "makedonation";
	}
	
	@PostMapping
	public String registerDonorAC(@ModelAttribute("donate") Donation donation) {
		
		
		
		donorservice.placeDonation(donation);
		//return "donorlist";
		//return "redirect:/registration?success";
		return "redirect:/makedonation?success";
}

}
