package com.Donation.charity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Donation.charity.entities.CompleteDonationDetails;
import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.DonationStatus;


public interface CompleteDonationDetailsRepository extends JpaRepository<CompleteDonationDetails, Integer>{

	//List<CompleteDonationDetails> findByCity(String city);

	List<CompleteDonationDetails> findByCityAndDonationstatus(String cityname,DonationStatus booked);

	List<CompleteDonationDetails> findByDaidAndDonationstatus(int da_id, String string);



	List<CompleteDonationDetails> findByDaidAndDonationstatusOrDonationstatus(int da_id, DonationStatus orderAccepted, DonationStatus pickedUp);
}
