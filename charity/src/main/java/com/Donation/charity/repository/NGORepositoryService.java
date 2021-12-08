package com.Donation.charity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Donation.charity.entities.Donor;
import com.Donation.charity.entities.NGO;
import com.Donation.charity.entities.RegistrationStatus;

@Repository
public interface NGORepositoryService extends JpaRepository<NGO, Integer> {

	//List<NGO> findByNgoregstatus(String name);
	NGO findByNgoemail(String username);
	List<NGO> findByRegistrationstatus(RegistrationStatus notVerified);
	
	
	

}
