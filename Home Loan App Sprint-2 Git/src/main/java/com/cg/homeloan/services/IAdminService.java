package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin); 
	public Admin getAdmin(int userId);
	public List<Admin> getAllAdmin();
	public Boolean isValidAdmin(String username, String password);
	}

