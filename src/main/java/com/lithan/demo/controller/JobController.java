 package com.lithan.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lithan.demo.dto.Company;
import com.lithan.demo.dto.Job;
import com.lithan.demo.dto.JobApplicant;
import com.lithan.demo.dto.JobTitle;
import com.lithan.demo.dto.JobType;
import com.lithan.demo.dto.UserAccount;
import com.lithan.demo.dto.UserProfile;
import com.lithan.demo.dto.WorkLevel;
import com.lithan.demo.service.UserServiceImp;
import com.lithan.demo.service.JobService;


// List Job
@Controller
public class JobController {
	@Autowired
	UserServiceImp service;
	@Autowired
	JobService jobService;
	
//	User
	@GetMapping(value = "/list-job")
	public String listJob(HttpSession session,Model M,@ModelAttribute("job-apply") JobApplicant jobApplicant) {
		session.getAttribute("user");
		
		UserProfile dataUser = (UserProfile) (session.getAttribute("user"));
		System.out.println("id = " + dataUser.getId());
		
		M.addAttribute("dataUser",dataUser);
		
		List <Job> listDataJob = jobService.showalljobData();
		
		M.addAttribute("dataJob",listDataJob);
		
		System.out.println("List Job = " + listDataJob);
		
		return "job";
	}
	@PostMapping(value="search-job")
	public String SearchJob(@RequestParam Map<Object,String> params,@ModelAttribute("job-apply") JobApplicant jobApplicant,Model M
			,HttpSession session) {
		String searchJob = params.get("search-job").toString().toLowerCase();
		String address = params.get("search-address").toString().toLowerCase();
		UserProfile dataUser = (UserProfile) (session.getAttribute("user"));
		
		System.out.println("data address : " + address);
		System.out.println("data job title : " + searchJob);
		List <Job> addressData = jobService.findByAddress(address);
		System.out.println("data job : " + addressData);
		List<Job> searchResult = new ArrayList<>();
		
		for(int i =0;i < addressData.size();i++) {
			if(addressData.get(i).getJobTitle().getJobTitleName().toLowerCase().contains(searchJob)) {
				System.out.println(addressData.get(i));
				searchResult.add(addressData.get(i));
			}
		}
		System.out.println("data job : " + searchResult);
		
		M.addAttribute("dataJob",searchResult);
		M.addAttribute("dataUser",dataUser);
		
		return "job";
	}
	
//	Applicant
	@PostMapping(value="submit-apply")
	public String submitApply(HttpSession session,Model M,@RequestParam Map<String, Object> params,@ModelAttribute("job-apply") JobApplicant jobApplicant) {
		UserProfile dataUser = (UserProfile) session.getAttribute("user");
		UserProfile userId = service.findByIdUserProfile(dataUser.getId());
		List <Job> listDataJob = jobService.showalljobData();
		
//		Job jobId = jobService.findByIdJob()
	
	
		M.addAttribute("dataJob",listDataJob);
		
		jobApplicant.setUser(userId);
		
		M.addAttribute("dataUser",dataUser);
		
		jobService.addJobApplicant(jobApplicant);
		
		System.out.println("List Apply Job = " + jobApplicant);	
		
		return "JobApplySucc";
	}
	
	@GetMapping(value="/applied")
	public String Applied() {
		return"JobApplySucc";
	}
	
	
//	Admin
	
	//	Post Job
	@GetMapping(value = "/post-job")
	public String postJob(HttpSession session,Model M, @ModelAttribute("job") Job job) {
		session.getAttribute("user");
		
		UserProfile dataUser = (UserProfile) session.getAttribute("user");
		
		Iterable<JobTitle> jobTitle = jobService.getAllJobTitle();
		Iterable<JobType> jobType = jobService.getAllJobType();
		Iterable<WorkLevel> workLevel = jobService.getAllWorkLevel();
		Iterable<Company> company = jobService.getAllCompany();
		
		M.addAttribute("dataAdmin",dataUser);
		M.addAttribute("jobTitle",jobTitle);
		M.addAttribute("jobType",jobType);
		M.addAttribute("workLevel",workLevel);
		M.addAttribute("company",company);
		
		return "postjob";
	}
	
	@PostMapping(value = "submit-job")
	public String submitJob(HttpSession session,Model M, @ModelAttribute("job") Job job,@RequestParam int edit) {
	UserProfile dataUser = (UserProfile) session.getAttribute("user");
	UserProfile userId = service.findByIdUserProfile(dataUser.getId());
		M.addAttribute("data",dataUser);
	
		System.out.println("Job Id" + edit);
		System.out.println(dataUser);
		job.setUser(userId);
		job.setId(edit);
		
		jobService.addJob(job);
		
		return "redirect:/list-job";
	}
	
//	Admin Manage Post Job
	
	@GetMapping(value = "/updateDataPostJob")
	public String updateDataPostJob(Model M,@RequestParam int edit,HttpSession session
	) {
		UserProfile dataUser = (UserProfile) session.getAttribute("user");
		Job searchId = jobService.findByIdJob(edit);
		
		System.out.println("Job Search Id = "+searchId);
		
		Iterable<JobTitle> jobTitle = jobService.getAllJobTitle();
		Iterable<JobType> jobType = jobService.getAllJobType();
		Iterable<WorkLevel> workLevel = jobService.getAllWorkLevel();
		Iterable<Company> company = jobService.getAllCompany();
	
		
		M.addAttribute("dataUser",dataUser);
		M.addAttribute("job",searchId);
		M.addAttribute("jobTitle",jobTitle);
		M.addAttribute("jobType",jobType);
		M.addAttribute("workLevel",workLevel);
		M.addAttribute("company",company);
		
		return "postjob";
	}
	
	@GetMapping(value= "/deleteDataPostJob")
	public String deleteDataPostJob(@RequestParam int delete) {
		
		jobService.deleteDataPostJob(delete);
		
		return "redirect:/list-job";
	}

	

}
