package com.lithan.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lithan.demo.dto.Job;


public interface JobRepo extends JpaRepository<Job,Integer> {
	@Query(value = "SELECT * FROM job_list WHERE job_address = ?1",nativeQuery = true)
	List <Job> findByAddress (String address);
}
