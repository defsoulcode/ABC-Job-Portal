package com.lithan.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bulk_email")
public class BulkEmail {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String subject;
private String email_to;
private String email_from;
private String description;

public BulkEmail(Long id, String subject, String email_to, String email_from, String description) {
	super();
	this.id = id;
	this.subject = subject;
	this.email_to = email_to;
	this.email_from = email_from;
	this.description = description;
}

public BulkEmail( String subject, String email_to, String email_from, String description) {
	super();
	this.subject = subject;
	this.email_to = email_to;
	this.email_from = email_from;
	this.description = description;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public String getEmail_to() {
	return email_to;
}

public void setEmail_to(String email_to) {
	this.email_to = email_to;
}

public String getEmail_from() {
	return email_from;
}

public void setEmail_from(String email_from) {
	this.email_from = email_from;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public BulkEmail() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "BulkEmail [id=" + id + ", subject=" + subject + ", email_to=" + email_to + ", email_from=" + email_from
			+ ", description=" + description + "]";
}
	
}
