package com.Donation.charity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Donation.charity.entities.Admin;
import com.Donation.charity.entities.Donor;



@Repository
public interface DonorRepositoryService extends JpaRepository<Donor, Integer> {


	
	Donor findByEmail(String email);

	

}
