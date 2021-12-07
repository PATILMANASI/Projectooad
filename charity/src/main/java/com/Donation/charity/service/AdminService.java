package com.Donation.charity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Donation.charity.entities.Admin;
import com.Donation.charity.entities.DA;
import com.Donation.charity.entities.NGO;
import com.Donation.charity.entities.Feedback;
import com.Donation.charity.repository.AdminRepositoryService;



public interface AdminService {

  
  public Admin login(String adname, String adpassword);

public List<NGO> getAllNGOs();

public void markNGOVerified(int id);

public List<DA>  getAllDAs();

public void MarkDAVerified(int id);

public List<Feedback> showAllFeedbacks();
  
}