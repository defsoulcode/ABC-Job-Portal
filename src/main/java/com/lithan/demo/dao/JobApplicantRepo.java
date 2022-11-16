package com.lithan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lithan.demo.dto.JobApplicant;


public interface JobApplicantRepo extends JpaRepository<JobApplicant,Integer> {
	
}
