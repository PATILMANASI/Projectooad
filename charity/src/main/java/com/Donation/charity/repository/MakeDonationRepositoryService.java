package com.Donation.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Donation.charity.entities.Donation;
@Repository
public interface MakeDonationRepositoryService extends JpaRepository<Donation, Long> {

}
