package com.Donation.charity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Donation.charity.entities.DA;
import com.Donation.charity.entities.NGO;
import com.Donation.charity.service.AdminService;

@Controller
public class VerifyNGOController {
	@Autowired
	private AdminService adminservice;
	

	
	@GetMapping("/verifyNGO")
	public String listNGOs(Model model) {
		model.addAttribute("listNGOs",adminservice.getAllNGOs());
		List<NGO> obj=adminservice.getAllNGOs();
		if (obj.isEmpty()) {
			return "redirect:/NoNGOAvailable?success";
		}
		return "verify_ngo";
	}
	
	@GetMapping("/markNGOVerified/{id}")
	public String markNGOVerified(@PathVariable (value="id") int id) {
		this.adminservice.markNGOVerified(id);
		return "redirect:/verifyNGO";

}
	@GetMapping("/markNGORejected/{id}")
	public String markNGORehected(@PathVariable (value="id") int id) {
		this.adminservice.markNGORejected(id);
		return "redirect:/verifyNGO";

}
}
