package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.exceptions.CustomerNotFoundException;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(int userId, Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(int userId) throws CustomerNotFoundException;
	public Customer getCustomer(int userId) throws CustomerNotFoundException;
	public List<Customer> getAllCustomers();
	public int getUserIdByUsername(String username) throws CustomerNotFoundException;
	public boolean isValidCustomer(String username, String password);
}
