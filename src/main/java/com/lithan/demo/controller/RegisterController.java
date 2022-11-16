package com.lithan.demo.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;
import com.lithan.demo.service.UserServiceImp;


@Controller
public class RegisterController {
	@Autowired
	UserServiceImp service;
	
	@GetMapping(value = "/register")
	public String Register() {
		
		return "Register";
		
	}
	
	@PostMapping (value = "/register-confirmation")
	public String Regist(Model M,@RequestParam Map<String, Object> params) {
		
		String user = params.get("username").toString();
		String email = params.get("email").toString();
		String password = params.get("password").toString();
		String firstname = params.get("fname").toString();
		String lastname = params.get("lname").toString();
		String address = params.get("address").toString();
		String phone = params.get("phone").toString();
		
		
		UserAccount checkEmail=service.findByEmail(email);
		System.out.println("data id Email = " + checkEmail);
		
		if (checkEmail == null) {
			UserAccount userAccount= new UserAccount(email,password);
			UserProfile userProfile= new UserProfile(userAccount,user,firstname,lastname,address,phone);
			
			service.adduserData(userProfile);
			service.addaccountData(userAccount);
			
			return "ConfirmRegister";
			
		}
		M.addAttribute("error","Email registered");
		
		return "Register";
}
			
	@GetMapping (value = "/thankyou")
	public String thankyouPage() {
		
		return "Thankyou";
	}
	
	
}

