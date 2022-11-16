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

@Table(name="job_type")
@Entity
public class JobType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "job_type")
	private String JobType;
	
	@OneToMany(mappedBy = "jobType")
	private Set<Job> job;

	public JobType(int id, String jobType, Set<Job> job) {
		super();
		this.id = id;
		JobType = jobType;
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobType() {
		return JobType;
	}

	public void setJobType(String jobType) {
		JobType = jobType;
	}

	public Set<Job> getJob() {
		return job;
	}

	public void setJob(Set<Job> job) {
		this.job = job;
	}
	
	

	public JobType() {
		super();
		// TODO Auto-generated constructor stub
	}
}
