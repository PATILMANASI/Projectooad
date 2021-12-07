package com.Donation.charity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Donation.charity.entities.DA;
import com.Donation.charity.entities.Feedback;
import com.Donation.charity.service.AdminService;
import com.Donation.charity.service.AdminService;

@Controller

public class ViewFeedbackController {
	@Autowired
	private AdminService adminservice;
	

	
@GetMapping("/viewFeedback")
	public String listDAs(Model model) {
		model.addAttribute("listFeedbacks",adminservice.showAllFeedbacks());
		List<Feedback> obj=adminservice.showAllFeedbacks();
		if (obj.isEmpty()) {
			return "redirect:/viewFeedback?success";
		}
		return "DisplayFeedbacks";
	}
	
	
}
