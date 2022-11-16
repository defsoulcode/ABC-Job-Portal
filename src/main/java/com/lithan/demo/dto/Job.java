package com.lithan.demo.dto;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.lithan.demo.dto.JobTitle;
import com.lithan.demo.dto.Company;
import com.lithan.demo.dto.JobApplicant;
import com.lithan.demo.dto.JobType;
import com.lithan.demo.dto.UserProfile;
import com.lithan.demo.dto.WorkLevel;

@Entity
@Table(name="job_list")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_job_company", referencedColumnName = "id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "id_job_title",referencedColumnName = "id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name = "id_job_type", referencedColumnName = "id")
	private JobType jobType;
	
	@ManyToOne
	@JoinColumn(name = "id_job_work_level", referencedColumnName = "id")
	private WorkLevel workLevel;
	
	@Column(name="job_status")
	private String Status;
	
	@Lob
	@Column(name="job_address",length=500)
	private String Address;
	
	@Column(name="job_salary")
	private int Salary;
	
	@Lob
	@Column(name="job_description",length=600)
	private String Description;
	
	@CreationTimestamp
	private Date created_at;
	
	@CreationTimestamp
	private Date update_at;
	
	@ManyToOne
	@JoinColumn(name = "id_user", referencedColumnName = "id")
	private UserProfile user;
	
	@OneToMany(mappedBy="job")
	private Set<JobApplicant> job;

	public Job(int id, Company company, JobTitle jobTitle, JobType jobType, WorkLevel workLevel, String status,
			String address, int salary, String description, Date created_at, Date update_at, UserProfile user) {
		super();
		this.id = id;
		this.company = company;
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.workLevel = workLevel;
		Status = status;
		Address = address;
		Salary = salary;
		Description = description;
		this.created_at = created_at;
		this.update_at = update_at;
		this.user = user;
	}


	public Job(String address, int salary, String description) {
		super();
		Address = address;
		Salary = salary;
		Description = description;
	}


	public Set<JobApplicant> getJob() {
		return job;
	}

	public void setJob(Set<JobApplicant> job) {
		this.job = job;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public WorkLevel getWorkLevel() {
		return workLevel;
	}

	public void setWorkLevel(WorkLevel workLevel) {
		this.workLevel = workLevel;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}





	@Override
	public String toString() {
		return "Job [id=" + id  + ", jobTitle=" + jobTitle + ", jobType=" + jobType
				+ ", workLevel=" + workLevel + ", Status=" + Status + ", Address=" + Address
				 + ", created_at=" + created_at + ", update_at=" + update_at + ", user="
				+ user + "]";
	}
	
	
}

