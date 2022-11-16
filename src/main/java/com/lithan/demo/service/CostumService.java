package com.lithan.demo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;
import com.lithan.demo.dao.AccountRepo;
import com.lithan.demo.dao.UserRepo;
import com.lithan.demo.security.ApplicationUserDetail;
@Service
public class CostumService implements UserDetailsService {
    @Autowired
	AccountRepo userrepo;
    @Autowired
   	UserServiceImp service;
    @Autowired(required = false)
    private HttpSession session;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount user=userrepo.findByEmail(username);
		
		session.setAttribute("session",user);
		
		if(user== null) {
			System.out.println("User name is Invalid");
			throw new UsernameNotFoundException("User Not Found with -> username or email: " + username);
		}
		
		return new ApplicationUserDetail(user);
	}

}
