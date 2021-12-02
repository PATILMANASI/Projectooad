package com.Donation.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Donation.charity.service.DAService;

@Controller
public class VerifyDAController {
	
	@Autowired
	private DAService daservice;
	

	
	@GetMapping("/verifyDA")
	public String listDAs(Model model) {
		model.addAttribute("listDAs",daservice.getAllDAs());
		return "verify_da";
	}
	
	@GetMapping("/markDAVerified/{id}")
	public String markDAVerified(@PathVariable (value="id") int id) {
		this.daservice.MarkVerified(id);
		return "redirect:/verifyDA";

}
	

}
