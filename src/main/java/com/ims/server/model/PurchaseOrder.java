package com.ims.server.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "po_number")
	private String poNumber;
	@Column(name = "supplier_id")
	private Long supplierId;
	@Column(name = "payment_terms")
	private String paymentTerms;
	@Column(name = "shipping_method")
	private String shipingMethod;
	@Column(name = "shipped_date")
	private Date shippedDate;
	@Column(name = "expected_delivery")
	private Date expectedDelivery;
	@Column(name = "delivery_date")
	private Date deliveryDate;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "received_date")
	private Date receivedDate;
	private BigDecimal taxes;
	@Column(name = "total_net")
	private BigDecimal totalNet;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getPaymentTerms() {
		return paymentTerms;
	}
	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}
	public String getShipingMethod() {
		return shipingMethod;
	}
	public void setShipingMethod(String shipingMethod) {
		this.shipingMethod = shipingMethod;
	}
	public Date getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}
	public Date getExpectedDelivery() {
		return expectedDelivery;
	}
	public void setExpectedDelivery(Date expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public BigDecimal getTaxes() {
		return taxes;
	}
	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}
	public BigDecimal getTotalNet() {
		return totalNet;
	}
	public void setTotalNet(BigDecimal totalNet) {
		this.totalNet = totalNet;
	}
	
	
}
