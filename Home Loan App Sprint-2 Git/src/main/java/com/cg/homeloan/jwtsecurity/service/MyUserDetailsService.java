package com.cg.homeloan.jwtsecurity.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.User;
import com.cg.homeloan.repositories.IUserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	
	
	
	//this method check the username is present in database or not if present it will return User object
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
			System.out.println(userName);
		 	User user = this.userRepository.findByUsername(userName);
		 	System.out.println(user);
			if(user==null) {
				throw new UsernameNotFoundException("User not Found!!");
			}
			else {
				return new MyUserDetails(user);
			}
		 
	}
	

}