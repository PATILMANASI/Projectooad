package com.Donation.charity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.service.DAService;
@Controller
public class DAAcceptOrderController {
	
	@Autowired
	private DAService daservice;
	
	@RequestMapping("/viewOrders")
	public String listOrders(Model model) {
		model.addAttribute("listOrders",daservice.getAllOrders());
		List<CompleteDonationDetails> obj=daservice.getAllOrders();
		if (obj.isEmpty()) {
			return "redirect:/DisplayNoOrders?success";
		}
		return "DAAcceptOrder";
	}
	@GetMapping("/bookOrder/{id}")
	public String bookOrder(@PathVariable (value="id") int id) {
		this.daservice.bookOrder(id);
		return "redirect:/viewOrders";

	}
	
}
