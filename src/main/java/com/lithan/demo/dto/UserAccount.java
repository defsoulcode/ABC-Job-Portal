package com.lithan.demo.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="user_account")
public class UserAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="password",length=60)
	private String password;
	@Column(name="email",length=50,unique=true)
	private String email;
	@OneToOne (mappedBy="user")
	private UserProfile userProfile;
	
	private String role;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String Password) {
		password = Password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String Email) {
		email = Email;
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public UserAccount(int id, String Password, String Email,String Role) {
		super();
		this.id = id;
		this.password = Password;
		this.email = Email;
		this.role = role;
	}


	public UserAccount(String email, String password) {
	super();
	this.password = password;
	this.email = email;
}


	public UserAccount(String Password, String Email, UserProfile userProfile) {
	super();
	password = Password;
	email = Email;
	this.userProfile = userProfile;
}


	public UserAccount(UserProfile userProfile) {
	super();
	this.userProfile = userProfile;
}


	public UserAccount() {
	super();
	// TODO Auto-generated constructor stub
}


@Override
public String toString() {
	return "UserAccount [id=" + id + ", password=" + password + ", email=" + email + ", ]";
}

}
