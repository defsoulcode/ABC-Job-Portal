package com.lithan.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;
import com.lithan.demo.dao.AccountRepo;
import com.lithan.demo.dao.UserRepo;

@Service
public class UserServiceImp{
	private PasswordEncoder passwordencoder;
//	Database
		@Autowired
		UserRepo urepo;
		@Autowired
		AccountRepo accountRepo;
		UserProfile user = new UserProfile();
		UserAccount account=new UserAccount();
		
		public UserServiceImp (PasswordEncoder encoder) {
			// TODO Auto-generated constructor stub
			this.passwordencoder=encoder;
		}
		
		public void adduserData(UserProfile l) {
			System.out.println(l);
			urepo.save(l);
		
		}
		
		public String addaccountData(UserAccount l) {
			System.out.println(l);
			l.setRole("USER");
			l.setPassword(passwordencoder.encode(l.getPassword()));
			accountRepo.save(l);
			return "DATA ADDED";
		}

	
		public List<UserProfile> showalluserData() {
			
				List<UserProfile> dball=urepo.findAll();
				
			return dball;
		}
		
		public void update(UserProfile up){
			 urepo.save(up);
		}
		
		public void updatePassword(UserAccount u){
			 accountRepo.save(u);
		}
		
		public void updateProfile(UserProfile u){
			 urepo.save(u);
		}
		
		
		public UserAccount showemailPassword(String email, String password) {
			
			UserAccount db = accountRepo.showByEmailPassword(email, password);
			
			return db;
		}
		
		public UserAccount findByEmail(String email) {
			 return accountRepo.findByEmail(email);
		}
	

		public List <UserProfile> findByfirstName(String firstName) {
	        return urepo.findByfirstName(firstName);
	    }

		
	public UserProfile findByIdUserAccount(int id) {
			
		UserProfile db = urepo.findByIdUserAccount(id);
		
		return db;
	}
	

	public UserProfile findByIdUserProfile(int id) {
		
		UserProfile db = urepo.findByIdUserProfile(id);
		
		return db;
}

		
		public void deleteData(int id) {
		
			urepo.deleteById(id);			
		}

	}	

