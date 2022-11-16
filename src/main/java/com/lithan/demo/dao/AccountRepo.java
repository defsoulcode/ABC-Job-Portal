package com.lithan.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;


public interface AccountRepo extends JpaRepository<UserAccount,Integer> {
	UserAccount findByEmail(String email);
	@Query(value = "SELECT id, email, password FROM user_account WHERE email = ?1 AND password = ?2", nativeQuery = true)
    UserAccount showByEmailPassword(String email,String Password);
	
	@Query (value = "SELECT * FROM user_account WHERE id = ?1",nativeQuery = true)
	UserAccount findById(int id);

}
