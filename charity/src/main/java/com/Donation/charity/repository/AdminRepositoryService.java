package com.Donation.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Donation.charity.entities.Admin;
@Repository
public interface AdminRepositoryService extends JpaRepository<Admin, Long>{
	Admin findByAdname(String adname);
}
