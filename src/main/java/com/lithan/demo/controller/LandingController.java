package com.lithan.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lithan.demo.dto.Job;
import com.lithan.demo.service.JobService;


@Controller
public class LandingController {
	
	@Autowired
	JobService jobService;
	@GetMapping(value = "/")
	public String Landing(Model M) {
		
		List <Job> listDataJob = jobService.showalljobData();
		
		M.addAttribute("dataJob",listDataJob);
		System.out.println("List Job = " + listDataJob.get(0).getCompany());
		return "index";
		
	}
}
