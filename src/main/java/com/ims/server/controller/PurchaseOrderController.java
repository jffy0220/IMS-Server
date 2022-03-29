package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.PurchaseOrder;
import com.ims.server.model.PurchaseOrderIncoming;
import com.ims.server.model.PurchaseOrderLineItems;
import com.ims.server.repository.PurchaseOrderLineItemRepository;
import com.ims.server.repository.PurchaseOrderRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

/*
 * For Purchase Orders, we will get a very interesting structure that will come into our server
 * We will get the purchase order structure, followed by the line items, so we need to create a new model, so we can then split it into two
 * I haven't done this before, so this will be testing
 */

@RestController
@Api(tags = { "Purchase Order" })
@SwaggerDefinition(tags = { @Tag(name = "Purchase Order", description = "Operations for Managing Purchase Orders") })
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderRepository poRepo;
	
	@Autowired
	private PurchaseOrderLineItemRepository poLineItemRepo;
	
	// There is further testing we need to do such as getting the total for each individual line item and the total for the entire purchase order, but we can do that another time
	@PostMapping(path = "/purchase-order")
	public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrderIncoming po) throws NotFoundException {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = po.getPurchaseOrder();
		Iterable<PurchaseOrderLineItems> lineItems = po.getLineItems();
		for (PurchaseOrderLineItems item : lineItems) {
			poLineItemRepo.save(item); // TESTING
		}
		return poRepo.save(purchaseOrder);
	}
}
