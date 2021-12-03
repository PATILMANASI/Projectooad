package com.Donation.charity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.service.NGOService;
@Controller
public class ReserveDonationController {

	@Autowired
	private NGOService ngoservice;
	

	
	@GetMapping("/viewDonation")
	public String listDonations(Model model) {
		model.addAttribute("listDonations",ngoservice.getAllDonations());
		List<CompleteDonationDetails> obj=ngoservice.getAllDonations();
		if (obj.isEmpty()) {
			return "redirect:/DisplayMessage?success";
		}
		return "PlaceDonation";
	}
	
	@GetMapping("/bookDonation/{id}")
	public String markNGOVerified(@PathVariable (value="id") int id) {
		this.ngoservice.bookDonation(id);
		return "redirect:/viewDonation";

}
}
