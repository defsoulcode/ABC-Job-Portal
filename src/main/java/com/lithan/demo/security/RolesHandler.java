package com.lithan.demo.security;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;
import com.lithan.demo.service.UserServiceImp;
@Component
public class RolesHandler implements AuthenticationSuccessHandler {
	@Autowired(required = false)
    private HttpSession session;
	@Autowired
    UserServiceImp service;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		
		Collection<? extends GrantedAuthority> auth=authentication.getAuthorities();
		String myurl=null;
		
		UserAccount user = (UserAccount) session.getAttribute("session");
		
		UserProfile findId = service.findByIdUserAccount(user.getId());
		System.out.println("id = " + user.getId());
		
		System.out.println(findId);
		System.out.println((UserAccount) session.getAttribute("session"));
		
		session.setAttribute("user",findId);
		
		
		for(GrantedAuthority my:auth) {
			System.out.println("roles is "+my);
			if(my.getAuthority().equals("ADMIN")) {
				myurl="/admin";
				session.setAttribute("role","ADMIN");
				break;
			}else if(my.getAuthority().equals("USER")) {
				myurl="/login-sucess";
				session.setAttribute("role","USER");
				break;
			}
		}
		System.out.println(myurl);
		new DefaultRedirectStrategy()
		.sendRedirect(request, response, myurl);
		
	}
}
