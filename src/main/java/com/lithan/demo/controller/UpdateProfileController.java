package com.lithan.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
public class UpdateProfileController {
	@Autowired
	UserServiceImp service;
	
@GetMapping(value = "/update")
	public String updateProfile(Model M, HttpSession session) {
	
	UserProfile dataUser = (UserProfile) session.getAttribute("user");
	
	M.addAttribute("update",dataUser);
	System.out.println("ini data user = " + dataUser);
	M.addAttribute("dataUser",dataUser);
	
	return "profile";
		
	}

@PostMapping(value = "/update-profile")
	public String updateprofileUser(@RequestParam Map <String,Object> params ,Model M, HttpSession session) {

	UserProfile dataUser = (UserProfile) (session.getAttribute("user"));	
	UserAccount userAccount = (UserAccount) session.getAttribute("session");
	
	System.out.println("id = " + dataUser.getId());
	
	String firstname = params.get("fname").toString();
	String lastname = params.get("lname").toString();
	String user = params.get("username").toString();
	String address = params.get("address").toString();
	String phone = params.get("number").toString();
	String bio = params.get("bio").toString();
	
	UserProfile dataUpdate = (UserProfile) service.findByIdUserProfile(dataUser.getId());
	
	dataUpdate.setFirstName(firstname);
	dataUpdate.setLastName(lastname);
	dataUpdate.setUserName(user);
	dataUpdate.setAddress(address);
	dataUpdate.setPhoneNumber(phone);
	dataUpdate.setBio(bio);
	
	service.updateProfile(dataUpdate);
	
	System.out.println(dataUpdate);
	
	M.addAttribute("update",dataUpdate);
	M.addAttribute("data",dataUser);
	session.setAttribute("user", dataUpdate);
	
	return "redirect:/update";
}

}


