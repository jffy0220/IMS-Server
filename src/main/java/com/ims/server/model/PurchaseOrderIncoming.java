package com.ims.server.model;

public class PurchaseOrderIncoming {

	private PurchaseOrder purchaseOrder;
	private Iterable<PurchaseOrderLineItems> lineItems;
	
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
	public Iterable<PurchaseOrderLineItems> getLineItems() {
		return lineItems;
	}
	
	public void setLineItems(Iterable<PurchaseOrderLineItems> lineItems) {
		this.lineItems = lineItems;
	}
}
