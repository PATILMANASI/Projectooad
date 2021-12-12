package com.Donation.charity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.entities.Donation;
import com.Donation.charity.service.DonorService;

@Controller
public class DonationHistoryController {
	
	@Autowired
	private DonorService donorservice;

	@GetMapping("/showMyDonations")
	public String showMyDonations(Model model) {
		model.addAttribute("listMyDonations",donorservice.getMyDonations());
		List<Donation> obj=donorservice.getMyDonations();
		if (obj.isEmpty()) {
			return "redirect:/DisplayMessage?success";
		}
		return "MyDonations";
		
	}
}
