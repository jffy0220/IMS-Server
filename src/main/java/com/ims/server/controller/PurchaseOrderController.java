package com.ims.server.controller;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	// NOTE: We need to add in the ability to see if a purchase order exists, and not allow that through. We can do that from the UI, but we need to double check at the server.
	@PostMapping(path = "/purchase-order")
	public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrderIncoming po) throws NotFoundException {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder = po.getPurchaseOrder();
		purchaseOrder = poRepo.save(purchaseOrder);
		BigDecimal total = new BigDecimal(BigInteger.ZERO, 4);
		Iterable<PurchaseOrderLineItems> lineItems = po.getLineItems();
		for (PurchaseOrderLineItems item : lineItems) {
			item.setPoNumberId(purchaseOrder.getId()); // TESTING
			BigDecimal totalItemCost = item.getPricePerUnit().multiply(new BigDecimal(item.getQuantity()));
			item.setTotal(totalItemCost);
			total = total.add(totalItemCost);
			poLineItemRepo.save(item); // TESTING
		}
		purchaseOrder.setTotalNet(total.add(purchaseOrder.getTaxes()));
		poRepo.save(purchaseOrder); // RESAVE THE PURCHASE ORDER, UPDATING THE TOTAL TAXES
		return purchaseOrder;
	}
	
	@GetMapping(path = "/purchase-order/single/no-items")
	public PurchaseOrder getSinglePurchaseOrder(@RequestParam Long id) throws NotFoundException {
		return poRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@GetMapping(path = "/purchase-order")
	public @ResponseBody Iterable<PurchaseOrder> getAllPurchaseOrders() {
		return poRepo.findAll();
	}
	
	@GetMapping(path = "/purchase-order/single/items")
	public PurchaseOrderIncoming getPurchaseOrderLineItems(@RequestParam Long id) throws NotFoundException {
		PurchaseOrder po = poRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
		Iterable<PurchaseOrderLineItems> poLineItems = poLineItemRepo.findAllByPoNumberId(po.getId());
		PurchaseOrderIncoming poTotal = new PurchaseOrderIncoming();
		poTotal.setPurchaseOrder(po);
		poTotal.setLineItems(poLineItems);
		return poTotal;
	}
}
