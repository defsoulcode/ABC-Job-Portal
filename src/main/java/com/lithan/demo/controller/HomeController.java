package com.lithan.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lithan.demo.service.UserServiceImp;
import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;

@Controller
public class HomeController {
	@Autowired
	UserServiceImp service;
	
	@GetMapping(value = "/home")
	public String Home(HttpSession session,Model M) {
		
		UserProfile dataUser = (UserProfile) session.getAttribute("user");
//		System.out.println(dataUser);
		
		M.addAttribute("dataUser",dataUser);
		
		return "Home";
	}
}
