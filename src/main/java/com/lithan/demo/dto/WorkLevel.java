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

@Table(name = "work_level")
@Entity
public class WorkLevel {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "work_level")
	private String WorkLevel;
	
	@OneToMany(mappedBy = "workLevel")
	private Set<Job> job;

	public WorkLevel(int id, String workLevel, Set<Job> job) {
		super();
		this.id = id;
		WorkLevel = workLevel;
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkLevel() {
		return WorkLevel;
	}

	public void setWorkLevel(String workLevel) {
		WorkLevel = workLevel;
	}

	public Set<Job> getJob() {
		return job;
	}

	public void setJob(Set<Job> job) {
		this.job = job;
	}
	
	

	public WorkLevel() {
		super();
		// TODO Auto-generated constructor stub
	}
}
