package com.lithan.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.demo.dto.Company;
import com.lithan.demo.dto.Job;
import com.lithan.demo.dto.JobApplicant;
import com.lithan.demo.dto.JobTitle;
import com.lithan.demo.dto.JobType;
import com.lithan.demo.dto.WorkLevel;
import com.lithan.demo.dao.CompanyRepo;
import com.lithan.demo.dao.JobApplicantRepo;
import com.lithan.demo.dao.JobRepo;
import com.lithan.demo.dao.JobTitleRepo;
import com.lithan.demo.dao.JobTypeRepo;
import com.lithan.demo.dao.WorkLevelRepo;

@Service
public class JobService {

	
	@Autowired
	JobRepo jobRepo;
	@Autowired
	JobTitleRepo jobTitleRepo;
	@Autowired
	JobTypeRepo jobTypeRepo;
	@Autowired
	WorkLevelRepo workLevelRepo;
	@Autowired
	CompanyRepo companyRepo;
	@Autowired
	JobApplicantRepo jobApplicantRepo;
	
	Job job = new Job();
	JobTitle jobTitle = new JobTitle();
	JobApplicant jobApplicant = new JobApplicant();
	
	public void addJob(Job l) {
		System.out.println(l);
		jobRepo.save(l);
	
	}
	
	public void addJobApplicant(JobApplicant l) {
		System.out.println(l);
		jobApplicantRepo.save(l);
	
	}
	
	public List<JobTitle> getAllJobTitle() {
        return jobTitleRepo.findAll();
    }
	
	public List<JobType> getAllJobType() {
        return jobTypeRepo.findAll();
    }

	public List<WorkLevel> getAllWorkLevel() {

		return workLevelRepo.findAll();
	}

	public List<Company> getAllCompany() {
		return companyRepo.findAll();
	}
	
	public List<Job> showalljobData() {
		
		List<Job> dball=jobRepo.findAll();
		
	return dball;
}
	public List <Job> findByAddress(String address) {
        return jobRepo.findByAddress(address);
    }
	
	public Job findByIdJob(int id) {
		
		Job db = jobRepo.findById(id).get();
		System.out.println("ini services: " + db);
		return db;
	}
	
	public void deleteDataPostJob(int id) {
		
		 jobRepo.deleteById(id);
		 
	}
}
