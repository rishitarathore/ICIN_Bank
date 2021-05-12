package org.simplilearn.workshop.model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String firstname;
	private String lastname;
	private Long phone;
	private String address;
	private String email;
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String password;
	
	@Type(type="date")
	private Date dob;
	private String identity;

	@Column(columnDefinition = "boolean default false")
	private boolean status;
	@Column(columnDefinition = "boolean default false")
	private boolean authorizationStatus;
	@Column(columnDefinition = "integer default 3", nullable = false)
	private int featureStatus = 3;

	@OneToOne(targetEntity = Account.class, mappedBy = "user", orphanRemoval = false, fetch = FetchType.LAZY)
	private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isAuthorizationStatus() {
		return authorizationStatus;
	}

	public void setAuthorizationStatus(boolean authorizationStatus) {
		this.authorizationStatus = authorizationStatus;
	}

	public int getFeatureStatus() {
		return featureStatus;
	}

	public void setFeatureStatus(int featureStatus) {
		this.featureStatus = featureStatus;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	

}
