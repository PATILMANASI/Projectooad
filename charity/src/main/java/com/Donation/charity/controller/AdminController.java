package com.Donation.charity.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Donation.charity.entities.Admin;
import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.service.AdminService;
import com.Donation.charity.service.DAService;

@Controller
public class AdminController {
	
	@Autowired
    private AdminService adminservice;
	

 
                                  
    @GetMapping("/adminlogin")    
    public ModelAndView login() {
     ModelAndView obj = new ModelAndView("adminlogin");
        obj.addObject("admin", new Admin());
        return obj;
    }
 
    @PostMapping("/adminlogin")
    public String login(@ModelAttribute("admin") Admin admin ) {
    
     Admin admin_obj = adminservice.login(admin.getUsername(), admin.getPassword());
    
 
     System.out.print(admin_obj);
     if(Objects.nonNull(admin_obj))
     {
  
     return "redirect:/AdminHome";
    
    
     } else {
     return "redirect:/adminlogin";
    
    
     }
    }
   
    
 /*   @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    
  
        return "redirect:/adminlogin";
    }*/
 
}


