package com.Donation.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Donation.charity.entities.Donor;
import com.Donation.charity.service.DonorService;
import com.Donation.charity.service.DonorServiceImpl;


@Controller
@RequestMapping("/donorsignin")
public class DonorLoginController {
	private DonorService donorservice;

	public DonorLoginController(DonorService donorservice) {
		super();
		this.donorservice = donorservice;
	}
    @ModelAttribute("donor")
	public Donor donorreg() {
		return new Donor();
	}
    
    @GetMapping
	public String showRegForm() {
		return "donor_signin_new";
	}
	
	@PostMapping
	public String registerDonorAC(@ModelAttribute("donor") Donor donorreg) {
		donorservice.save(donorreg);
		//return "donorlist";
		//return "redirect:/registration?success";
		return "redirect:/donorsignin?success";
}
}