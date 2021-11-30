package com.Donation.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Donation.charity.service.NGOService;
@Controller
public class VerifyNGOController {
	@Autowired
	private NGOService ngoservice;
	

	
	@GetMapping("/verifyNGO")
	public String listNGOs(Model model) {
		model.addAttribute("listNGOs",ngoservice.getAllNGOs());
		return "verify_ngo";
	}
	
	@GetMapping("/markNGOVerified/{id}")
	public String markNGOVerified(@PathVariable (value="id") int id) {
		this.ngoservice.MarkVerified(id);
		return "redirect:/verifyNGO";

}
}
