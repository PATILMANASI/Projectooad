package com.Donation.charity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Donation.charity.entities.DA;

public interface DARepositoryService extends JpaRepository<DA, Integer> {
	
	List<DA> findByDaregstatus(String name);
	DA findByDaemail(String username);
}
