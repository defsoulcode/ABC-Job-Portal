package com.lithan.demo.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lithan.demo.dto.Job;

@Entity
@Table(name = "job_title")
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "job_title")
	private String JobTitleName;
	
	@OneToMany(mappedBy = "jobTitle")
	private Set<Job> job;

	public JobTitle(int id, String jobTitleName, Set<Job> job) {
		super();
		this.id = id;
		JobTitleName = jobTitleName;
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitleName() {
		return JobTitleName;
	}

	public void setJobTitleName(String jobTitleName) {
		JobTitleName = jobTitleName;
	}

	public Set<Job> getJob() {
		return job;
	}

	public void setJob(Set<Job> job) {
		this.job = job;
	}
	
	

	public JobTitle() {
		super();
		// TODO Auto-generated constructor stub
	}
}
