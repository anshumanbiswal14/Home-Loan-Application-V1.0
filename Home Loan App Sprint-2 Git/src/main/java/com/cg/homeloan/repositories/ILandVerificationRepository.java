package com.cg.homeloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.LandVerificationOfficer;

public interface ILandVerificationRepository extends JpaRepository<LandVerificationOfficer, Integer> {

	public LandVerificationOfficer findByUsernameAndPassword(String username, String password);

}


