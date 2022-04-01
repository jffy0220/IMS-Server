package com.ims.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "warehouse_name")
	private String warehouseName;
	
	@Column(name = "address_1")
	private String addressOne;
	
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
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
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
	public String getPoc() {
		return poc;
	}
	public void setPoc(String poc) {
		this.poc = poc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "address_2")
	private String addressTwo;
	
	private String city;
	private String state;
	private String country;
	private String zip;
	private String poc;
	private String email;
	private String phone;
}
