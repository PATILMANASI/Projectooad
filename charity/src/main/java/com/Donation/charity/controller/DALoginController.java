package com.Donation.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Donation.charity.entities.DA;
import com.Donation.charity.service.DAService;

@Controller
@RequestMapping("/dasignin")
public class DALoginController {
	
	@Autowired
	private DAService daservice;
	
	 @GetMapping
		public String showDARegForm() {
			return "DA_signup";
		}
	
	 

		public DALoginController(DAService daservice) {
		super();
		this.daservice = daservice;
	}



		@ModelAttribute("da")
		public DA dareg() {
			return new DA();
		}
	   
		
		@PostMapping
		public String registerDAAC(@ModelAttribute("da") DA dareg) {
			daservice.saveDADetails(dareg);
			
			return "redirect:/dasignin?success";
	}

}
