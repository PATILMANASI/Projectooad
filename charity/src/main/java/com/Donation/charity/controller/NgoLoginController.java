package com.Donation.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.NGO;
import com.Donation.charity.service.DonorService;
import com.Donation.charity.service.NGOService;

@Controller
@RequestMapping("/ngosignin")
public class NgoLoginController {
	@Autowired
	private NGOService ngoservice;
	
	 @GetMapping
		public String showNGORegForm() {
			return "NGO_signup";
		}
	
	 

		public NgoLoginController(NGOService ngoservice) {
		super();
		this.ngoservice = ngoservice;
	}



		@ModelAttribute("ngo")
		public NGO ngoreg() {
			return new NGO();
		}
	   
		
		@PostMapping
		public String registerNGOAC(@ModelAttribute("ngo") NGO ngoreg) {
			ngoservice.saveNGODetails(ngoreg);
			
			return "redirect:/ngosignin?success";
	}

}
