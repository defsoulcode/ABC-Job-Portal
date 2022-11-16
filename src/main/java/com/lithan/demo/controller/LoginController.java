package com.lithan.demo.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;
import com.lithan.demo.service.UserServiceImp;

@Controller
public class LoginController {
	@Autowired
	UserServiceImp service;
	
	@GetMapping (value= "/login")
		public String Login(String error, Model m){
		if (error != null) {
			m.addAttribute("error", "email or password not registered");
		}
			return "Login";
		}
	
	@GetMapping (value= "/login-sucess")
	public String LoginSuccess(){
		
		return "LoginSuccess";
	}
	
}
