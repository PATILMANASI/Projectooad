package com.Donation.charity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.entities.DA;
import com.Donation.charity.service.AdminService;


@Controller
public class VerifyDAController {
	
	@Autowired
	private AdminService adminservice;
	

	
	@GetMapping("/verifyDA")
	public String listDAs(Model model) {
		model.addAttribute("listDAs",adminservice.getAllDAs());
		List<DA> obj=adminservice.getAllDAs();
		if (obj.isEmpty()) {
			return "redirect:/DisplayNoDAs?success";
		}
		return "Verify_DA";
	}
	
	@GetMapping("/markDAVerified/{id}")
	public String markDAVerified(@PathVariable (value="id") int id) {
		this.adminservice.MarkDAVerified(id);
		return "redirect:/verifyDA";

}
	@GetMapping("/markDARejected/{id}")
	public String markDARejected(@PathVariable (value="id") int id) {
		this.adminservice.MarkDARejected(id);
		return "redirect:/verifyDA";

}
	

}
