package com.Donation.charity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Donation.charity.entities.Donation;
import com.Donation.charity.entities.NGO;
@Repository
public interface MakeDonationRepositoryService extends JpaRepository<Donation, Integer> {

//	List<Donation> findByCity(String city);
}
