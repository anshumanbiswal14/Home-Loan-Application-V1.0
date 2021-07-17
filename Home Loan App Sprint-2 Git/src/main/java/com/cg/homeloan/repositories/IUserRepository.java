package com.cg.homeloan.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.homeloan.entities.User;

public interface IUserRepository extends JpaRepository<User,Integer>{
	
//	@Query("SELECT u from User u WHERE u.username =:username")
	public User findByUsername(String username);
	
	@Query("SElECT  u from User u WHERE u.username=:username")
	public boolean usernameExists(@Param("username") String username);
	
    public Boolean existsByUsername(String username);

}
