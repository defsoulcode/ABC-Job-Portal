package com.lithan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.demo.dto.JobType;

public interface JobTypeRepo extends JpaRepository<JobType,Integer> {
		
}
