package com.Donation.charity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Donation.charity.entities.DA;
import com.Donation.charity.entities.RegistrationStatus;

public interface DARepositoryService extends JpaRepository<DA, Integer> {
	
	//List<DA> findByDaregstatus(String name);
	DA findByEmail(String username);
	List<DA> findByRegistrationstatus(RegistrationStatus notVerified);
}
