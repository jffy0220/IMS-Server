package com.ims.server.model;

/*
 * NOTE
 * We do not have any security built into the application yet, we will build in password hashing and authentication at a later date, probably when the server is in a stable version for production
 * https://reflectoring.io/spring-security-password-handling/
 * last login function is not created yet
 * deleting a user is not created yet => NOTE: it will only be a soft delete
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "password_hash")
	private Long passwordHash;
	
	private Boolean active;
	
	@Column(name = "last_login")
	private Date lastLogin;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@Column(name = "date_deleted")
	private Date dateDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(Long passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}
	
	
}
