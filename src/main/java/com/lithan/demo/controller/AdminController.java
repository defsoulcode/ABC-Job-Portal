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
public class AdminController {

	@Autowired
	UserServiceImp service;
	@Autowired
	private HttpSession session;
	
	@GetMapping(value = "/admin")
	public String Admin(Model M,@RequestParam Map<Object,String> params,UserProfile search) {
	
		UserProfile dataUser = (UserProfile) session.getAttribute("user");
		List <UserProfile> searchuser=service.showalluserData();
		
		M.addAttribute("attribute",searchuser);
		M.addAttribute("dataAdmin",dataUser);
		
		System.out.println(dataUser);
		
		return "viewuser";
	}
	
	@PostMapping(value="/search-data")
	public String SearchUser(@RequestParam Map<Object,String> params, UserProfile search,Model M,HttpSession session) {
		String firstname = params.get("search").toString();
		
		List <UserProfile> searchuser = service.showalluserData();
		List <UserProfile> findfirstName = service.findByfirstName(firstname);
		UserProfile dataUser = (UserProfile) session.getAttribute("user");
		
		M.addAttribute("data",dataUser);
		M.addAttribute("attribute",findfirstName);
		
		return "viewuser";
		
	}
	
	@GetMapping(value = "/updateDataAdmin")
	public String updateDataAdmin(Model M,@RequestParam int edit) {
		UserProfile searchId = service.findByIdUserProfile(edit);
		UserProfile dataUser = (UserProfile) session.getAttribute("user");
		
		M.addAttribute("update",searchId);
	
		return "profile";
	}
	
	@PostMapping(value = "/update-user")
	public String updateprofileUser(@RequestParam Map <String,Object> params ,Model M, HttpSession session) {

	UserProfile dataUser = (UserProfile) (session.getAttribute("user"));	
	UserAccount userAccount = (UserAccount) session.getAttribute("session");
	 
//	System.out.println(userAccount);
	System.out.println("Data User = " + dataUser.getId());
	
	int iduserProfile = (int)Integer.parseInt(params.get("id-user-profile").toString());
	System.out.println(iduserProfile);
	
	String firstname = params.get("fname").toString();
	String lastname = params.get("lname").toString();
	String user = params.get("username").toString();
	String address = params.get("address").toString();
	String phone = params.get("number").toString();
	String bio = params.get("bio").toString();
	
	UserProfile Id = (UserProfile) service.findByIdUserProfile(iduserProfile);
//	System.out.println(Id);
	
	Id.setFirstName(firstname);
	Id.setLastName(lastname);
	Id.setUserName(user);
	Id.setAddress(address);
	Id.setPhoneNumber(phone);
	Id.setBio(bio);
	
	service.updateProfile(Id);
	
	M.addAttribute("update",Id);
//	M.addAttribute("dataAdmin",dataUser);
	session.setAttribute("dataUser", Id);
	
	return "redirect:/admin";
}
	
	
	@GetMapping(value= "/deleteDataAdmin")
	public String deleteDataAdmin(@RequestParam int delete) {
		
		service.deleteData(delete);
		
		return "redirect:/admin";
	}
	
}
