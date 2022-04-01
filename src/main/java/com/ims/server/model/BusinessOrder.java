package com.ims.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "b2b_order")
public class BusinessOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "order_number")
	private String orderNumber;
	
	@Column(name = "b2b_id")
	private Long businessId;
	
	@Column(name = "b2b_location")
	private String businessLocation;
	
	@Column(name = "address_1")
	private String addressOne;
	
	@Column(name = "address_2")
	private String addressTwo;
	
	private String city;
	private String state;
	private String country;
	private String zip;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@Column(name = "date_cancelled")
	private Date dateCancelled;
	
	@Column(name = "seller_notes")
	private String sellerNotes;
	
	@Column(name = "customer_request")
	private String customerRequest;
	
	private Boolean reorder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getBusinessLocation() {
		return businessLocation;
	}

	public void setBusinessLocation(String businessLocation) {
		this.businessLocation = businessLocation;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateCancelled() {
		return dateCancelled;
	}

	public void setDateCancelled(Date dateCancelled) {
		this.dateCancelled = dateCancelled;
	}

	public String getSellerNotes() {
		return sellerNotes;
	}

	public void setSellerNotes(String sellerNotes) {
		this.sellerNotes = sellerNotes;
	}

	public String getCustomerRequest() {
		return customerRequest;
	}

	public void setCustomerRequest(String customerRequest) {
		this.customerRequest = customerRequest;
	}

	public Boolean getReorder() {
		return reorder;
	}

	public void setReorder(Boolean reorder) {
		this.reorder = reorder;
	}
}
