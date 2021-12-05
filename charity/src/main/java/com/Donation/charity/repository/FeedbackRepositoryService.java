package com.Donation.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Donation.charity.entities.Feedback;

@Repository
public interface FeedbackRepositoryService extends JpaRepository<Feedback, Long> {
	
}
