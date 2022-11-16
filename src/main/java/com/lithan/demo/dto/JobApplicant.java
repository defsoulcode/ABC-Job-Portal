package com.lithan.demo.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name= "job_applicant")
public class JobApplicant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_job", referencedColumnName = "id")
	private Job job;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	private UserProfile user;
	
	@Lob
	@Column(name="job_apply_content",length=500)
	private String jobApplyContent;
	
	public JobApplicant(int id, Job job, UserProfile user, String jobApplyContent) {
		super();
		this.id = id;
		this.job = job;
		this.user = user;
		this.jobApplyContent = jobApplyContent;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public String getJobApplyContent() {
		return jobApplyContent;
	}

	public void setJobApplyContent(String jobApplyContent) {
		this.jobApplyContent = jobApplyContent;
	}

	public JobApplicant() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "JobApplicant [id=" + id + ", job=" + job + ", user=" + user + ", jobApplyContent=" + jobApplyContent
				+ "]";
	}
	
	
	
}

