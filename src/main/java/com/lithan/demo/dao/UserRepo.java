package com.lithan.demo.dao;


import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserProfile,Integer> {
	@Query(value = "SELECT * FROM user_profile_data WHERE firstname = ?1",nativeQuery = true)
	List <UserProfile> findByfirstName (String firstname);
	@Query (value = "SELECT * FROM user_profile_data WHERE id_account = ?1",nativeQuery = true)
	UserProfile findByIdUserAccount(int id);
	
	@Query (value = "SELECT * FROM user_profile_data WHERE id = ?1",nativeQuery = true)
	UserProfile findByIdUserProfile(int id);
	
	@Query (value = "SELECT * FROM user_profile_data WHERE username = ?1",nativeQuery = true)
	UserProfile findByUserName(String username);
	

}


