package com.Donation.charity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Donation.charity.entities.Donor;
import com.Donation.charity.service.DonorService;



@Controller
public class MainController {
	@Autowired
	private DonorService donorservice;
	
	@GetMapping("/")
	public String login() {
		return "index";
	}
	
	@GetMapping("/adminlogin")
	public String adloginpage() {
		return "adminlogin";
	}
	
		
	
	
	
	@GetMapping("/ngologin")
	public String ngologinpage() {
		return "ngologin";
	}
	
	@GetMapping("/DAlogin")
	public String DAloginpage() {
		return "DAlogin";
	}
	@GetMapping("/donorhome")
	public String showdonorhome() {
		return "donor_home";
	}
/*	@GetMapping("/makedonation")
	public String showMakeDonation() {
		return "makedonation";
	}*/

	

}
