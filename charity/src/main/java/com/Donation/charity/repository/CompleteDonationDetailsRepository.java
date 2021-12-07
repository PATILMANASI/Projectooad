package com.Donation.charity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.entities.Donation;

public interface CompleteDonationDetailsRepository extends JpaRepository<CompleteDonationDetails, Integer>{

	//List<CompleteDonationDetails> findByCity(String city);

	List<CompleteDonationDetails> findByCityAndDonationstatus(String cityname,String string);

	List<CompleteDonationDetails> findByDaidAndDonationstatus(int da_id, String string);

	List<CompleteDonationDetails> findByDaidAndDonationstatusAndDonationstatus(int da_id, String string,
			String string2);

	List<CompleteDonationDetails> findByDaidAndDonationstatusOrDonationstatus(int da_id, String string, String string2);
}
