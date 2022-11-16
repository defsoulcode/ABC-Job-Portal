package com.lithan.demo.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;
import com.lithan.demo.service.UserServiceImp;

@Controller
public class ForgotPasswordController {
	
@Autowired
UserServiceImp service;
	
@GetMapping (value= "/confirmation-email")
public String ConfirmationEmail(){
	
	return "ForgotPass";
}

@GetMapping (value= "/resetpassword")
public String ResetMaping(){
	
	return "NewPassword";
}

@GetMapping (value= "/thankyoureset")
public String thankyou(){
	
	return "FPSuccess";
}

@PostMapping (value = "/resetpassword")
public String ResetPass(@RequestParam Map<String, Object> params, HttpSession session,Model M) {
	
	String email = params.get("email").toString();
	UserAccount data = (UserAccount) service.findByEmail(email);
	
	if (data == null) {
		M.addAttribute("error","email must be registered");
		
		return "ForgotPass";
		
	}else {
		
		session.setAttribute("password",data);
		session.setAttribute("email", email);
		
		return "NewPassword";
	}
}

@Autowired
private PasswordEncoder passwordencoder;

@PostMapping (value = "/thankyoureset")
public String thank(@RequestParam Map<String, Object> params, HttpSession session) {
	String email = (String) session.getAttribute("email");
	UserAccount password = (UserAccount) session.getAttribute("password");
	
	
	String pass = params.get("ps").toString();
	String confirmPass = params.get("c_ps").toString();
	
	if(pass.equals(confirmPass)) {
		UserAccount dataPassword = password;
		dataPassword.setPassword(passwordencoder.encode(pass));
		
		service.updatePassword(dataPassword);
		
		return "FPSuccess";

	}else{
	
		return "redirect:/resetpassword";
	}
	
}

}
