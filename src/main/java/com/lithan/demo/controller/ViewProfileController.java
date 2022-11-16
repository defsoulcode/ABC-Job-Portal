package com.lithan.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;
import com.lithan.demo.service.UserServiceImp;

@Controller
public class ViewProfileController {
	
@Autowired
UserServiceImp service;
	
@GetMapping(value = "/view")
public String viewProfile(Model M, HttpSession session,@RequestParam int show) {
	
		UserProfile searchId = service.findByIdUserProfile(show);
		UserProfile dataUser = (UserProfile) session.getAttribute("user");
		
		M.addAttribute("user",searchId);
		session.getAttribute("user");
		M.addAttribute("dataUser",dataUser);
		
	return "viewProfile";
	}
}
