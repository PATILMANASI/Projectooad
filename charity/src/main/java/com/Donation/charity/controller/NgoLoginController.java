package com.Donation.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ngosignin")
public class NgoLoginController {
	
	 @GetMapping
		public String showRegForm() {
			return "NGO_signup";
		}

}
