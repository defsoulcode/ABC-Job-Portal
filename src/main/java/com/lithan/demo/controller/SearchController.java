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
public class SearchController {
	
@Autowired
UserServiceImp service;

@GetMapping(value = "/search")
public String Search(Model M, HttpSession session) {
	
	List <UserProfile> searchuser = service.showalluserData();
	UserProfile dataUser = (UserProfile) session.getAttribute("user");
			
	M.addAttribute("attribute",searchuser);
	M.addAttribute("dataUser",dataUser);
	
	return "SearchUser";
}

@PostMapping(value="/search-user")
public String SearchUser(@RequestParam Map<Object,String> params, UserProfile search,Model M,HttpSession session) {
	String firstname = params.get("search").toString();
	
	List <UserProfile> searchuser = service.showalluserData();
	List <UserProfile> findfirstName = service.findByfirstName(firstname);
	UserProfile dataUser = (UserProfile) session.getAttribute("user");
	
	M.addAttribute("dataUser",dataUser);
	M.addAttribute("attribute",findfirstName);
	
	return "SearchUser";
	
}

}
