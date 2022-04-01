package com.ims.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "b2b_order")
public class BusinessLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "company_id")
	private Long companyId;
	
	@Column(name = "poc_1")
	private String pocOne;
	
	@Column(name = "email_1")
	private String emailOne;
	
	@Column(name = "phone_1")
	private String phoneOne;
	
	@Column(name = "poc_2")
	private String pocTwo;
	
	@Column(name = "email_2")
	private String emailTwo;
	
	@Column(name = "phone_2")
	private String phoneTwo;
	
	@Column(name = "poc_3")
	private String pocThree;
	
	@Column(name = "email_3")
	private String emailThree;
	
	@Column(name = "phone_3")
	private String phoneThree;
	
	@Column(name = "address_1")
	private String addressOne;
	
	@Column(name = "address_2")
	private String addressTwo;
	
	private String city;
	private String state;
	private String country;
	private String zip;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getPocOne() {
		return pocOne;
	}
	public void setPocOne(String pocOne) {
		this.pocOne = pocOne;
	}
	public String getEmailOne() {
		return emailOne;
	}
	public void setEmailOne(String emailOne) {
		this.emailOne = emailOne;
	}
	public String getPhoneOne() {
		return phoneOne;
	}
	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}
	public String getPocTwo() {
		return pocTwo;
	}
	public void setPocTwo(String pocTwo) {
		this.pocTwo = pocTwo;
	}
	public String getEmailTwo() {
		return emailTwo;
	}
	public void setEmailTwo(String emailTwo) {
		this.emailTwo = emailTwo;
	}
	public String getPhoneTwo() {
		return phoneTwo;
	}
	public void setPhoneTwo(String phoneTwo) {
		this.phoneTwo = phoneTwo;
	}
	public String getPocThree() {
		return pocThree;
	}
	public void setPocThree(String pocThree) {
		this.pocThree = pocThree;
	}
	public String getEmailThree() {
		return emailThree;
	}
	public void setEmailThree(String emailThree) {
		this.emailThree = emailThree;
	}
	public String getPhoneThree() {
		return phoneThree;
	}
	public void setPhoneThree(String phoneThree) {
		this.phoneThree = phoneThree;
	}
	public String getAddressOne() {
		return addressOne;
	}
	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	public String getAddressTwo() {
		return addressTwo;
	}
	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
