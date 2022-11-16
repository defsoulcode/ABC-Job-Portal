package com.lithan.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lithan.demo.dto.UserProfile;
import com.lithan.demo.dto.BulkEmail;
import com.lithan.demo.service.BulkEmailService;
import com.lithan.demo.service.UserServiceImp;

@Controller
public class BulkEmailController {
	@Autowired
	private HttpSession session;
	@Autowired
	UserServiceImp service;
	@Autowired
	BulkEmailService bulkService;
	
	@GetMapping(value="/bulk-email")
	public String BulkEmail(Model M) {
		UserProfile dataUser = (UserProfile) session.getAttribute("user");
		List <UserProfile> searchuser=service.showalluserData();
		
		M.addAttribute("dataAdmin",dataUser);
		M.addAttribute("attribute",searchuser);
		
		return "bulkemail";
	}
	
	@PostMapping(value="sent-bulk-email")
	public String SentBulkEmail(@RequestParam Map<String,Object> params, Model M) {
		System.out.println("data = " + params.get("emails").toString());
		String email = params.get("emails").toString();
		String subject = params.get("subject").toString();
		String description = params.get("description").toString();		

		if (email.isEmpty()) {
			
			M.addAttribute("error","email not must be empty");
			
			return "bulkemail";
			
		}else {
			String[] dataEmail =params.get("emails").toString().split(",");
			
			for(int i = 0; i<= dataEmail.length - 1; i++) {
				System.out.println("cobaa = "+dataEmail[i]);
				BulkEmail bulkEmail = new BulkEmail(subject,dataEmail[i],"admin@gmail.com",description);
				bulkService.sentBulk(bulkEmail);
				bulkService.sendEmail(subject, dataEmail[i], description);
			}

		}
		
		return "bulksuccess";
	}
	

	@GetMapping(value="/bulk-email-success")
	public String BulkEmail() {
		return"bulksuccess";
	}
	
}

