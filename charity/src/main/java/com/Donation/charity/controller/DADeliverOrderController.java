package com.Donation.charity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.service.DAService;
@Controller
public class DADeliverOrderController {
	
	@Autowired
	private DAService daservice;
	
	  @GetMapping("/updateOrderStatus")
	     public String updateOrderStatus(Model model) {
	    	 
			model.addAttribute("listAcceptedOrders",daservice.getAllAcceptedOrders());
			List<CompleteDonationDetails> obj=daservice.getAllAcceptedOrders();
			if (obj.isEmpty()) {
				return "redirect:/DisplayNoOrders?success";
			}
			return "update_order_status";

	  }
	  @GetMapping("/OrderPickedUp/{id}")
		public String OrderPickedUp(@PathVariable (value="id") int id) {
			this.daservice.updateOrderStatusPickedUp(id);
			return "redirect:/updateOrderStatus";

		}
	  @GetMapping("/OrderDelivered/{id}")
		public String OrderDelivered(@PathVariable (value="id") int id) {
			this.daservice.updateOrderStatusDelivered(id);
			return "redirect:/updateOrderStatus";

		}
}
