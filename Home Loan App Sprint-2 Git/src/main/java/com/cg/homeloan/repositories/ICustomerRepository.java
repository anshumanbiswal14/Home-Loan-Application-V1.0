package com.cg.homeloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.homeloan.entities.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByUsernameAndPassword(String username, String password);
	public Customer findByUsername(String username);
}
