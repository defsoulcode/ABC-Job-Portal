package com.lithan.demo.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_profile_data")
public class UserProfile {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private int id;


@Column(name="username",length=50)
private String userName;

@Column(name="firstname",length=25)
private String firstName;

@Column(name="lastname",length=25)
private String lastName;

@Column(name="address",length=50)
private String address;

@Column(name="phone",length=20)
private String phoneNumber;

@Column(name="bio",length=100)
private String bio;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn  (name="id_account", referencedColumnName = "id")
private UserAccount user;

@OneToMany(mappedBy = "user")
private Set<Job> job;

@OneToMany(mappedBy = "user")
private Set<JobApplicant> jobApplicant;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public UserAccount getUser() {
	return user;
}
public void setUser(UserAccount user) {
	this.user = user;
}


public String getBio() {
	return bio;
}
public void setBio(String bio) {
	this.bio = bio;
}



public Set<Job> getJob() {
	return job;
}
public void setJob(Set<Job> job) {
	this.job = job;
}

public UserProfile(int id, String userName, String firstName, String lastName, String address, String phoneNumber,
		String bio, UserAccount user, Set<Job> job) {
	super();
	this.id = id;
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.bio = bio;
	this.user = user;
	this.job = job;
}
public UserProfile(String userName, String firstName, String lastName, String address, String phoneNumber,
		String bio, UserAccount user) {
	super();
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.bio = bio;
	this.user = user;
}

public UserProfile(int id, String userName, String firstName, String lastName, String address, String phoneNumber,
		UserAccount user) {
	super();
	this.id = id;
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.user = user;
}

public UserProfile(UserAccount user, String userName, String firstName, String lastName, String address, String phoneNumber) {
	super();
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.user = user;
}


public UserProfile(String userName, String firstName, String lastName, String address, String phoneNumber, String bio) {
	super();
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.bio = bio;
}
public UserProfile(String firstName) {
	super();
	this.firstName = firstName;
}

public UserProfile(UserAccount user) {
	super();
	this.user = user;
}
public UserProfile() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "UserProfile [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", bio=" + bio + ", user=" + user + "]";
}

}
