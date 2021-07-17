package com.cg.homeloan.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>{
		

	public Admin findByUsernameAndPassword(String username, String password);
}