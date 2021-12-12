package com.Donation.charity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	/*@GetMapping("/adminlogin")
	public String adloginpage() {
		return "adminlogin";
	}*/
	
		
	
	
	
	@GetMapping("/ngologin")
	public String ngologinpage() {
		return "NGO_login";
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
	
	@GetMapping("/donornewlogin")
	public String showPage() {
		return "donor_login_new";
	}
	
	@GetMapping("/feedback")
	public String showFeedbackPage() {
		return "feedback";
	}
	
	@GetMapping("/DAhome")
	public String showDAhomepage()
	{
		return "da_home";
	}
	@GetMapping("/DisplayMessage")
	public String displayMessage() {
		return "DisplayMessage";
	}
	@GetMapping("/DisplayNoOrders")
	public String displayNoOrdersAvailable() {
		return "NoOrdersAvailable";
	}

	@GetMapping("/DisplayNoDAs")
	public String displayNoDAsAvailable() {
		return "NoDAsAvailable";
	}
	@GetMapping("/NGOHome")
	public String showNGOHomePage() {
		return "NGOhome";
	}

	@GetMapping("/AdminHome")
	public String showAdminHomePage() {
		return "admin_home";
	}
	@GetMapping("/About")
	public String showAboutPage() {
		return "about";
	}
	@GetMapping("/NoNGOAvailable")
	public String showNoNGOAvailable() {
		return "NoNGOAvailable";
	}
	@GetMapping("/Index")
	public String showIndexPage() {
		return "index";
	}
	@GetMapping("NOOrdersToUpdateStatus")
	public String showNoOrdersAvailable() {
		return "NOOrdersToUpdateStatus";
	}
	
	

}
