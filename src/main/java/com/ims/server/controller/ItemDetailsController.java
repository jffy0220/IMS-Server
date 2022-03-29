package com.ims.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.ItemDetails;
import com.ims.server.repository.ItemDetailsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@Api(tags = { "Item" })
@SwaggerDefinition(tags = { @Tag(name = "Item", description = "Operations for Managing an Item") })
public class ItemDetailsController {
	@Autowired
	private ItemDetailsRepository itemDetailsRepo;
	
	@GetMapping(path = "/item-details")
	public @ResponseBody Iterable<ItemDetails> getAllItems() {
		return itemDetailsRepo.findAll();
	}
	
	@PostMapping(path = "/item-details")
	public ItemDetails newItem(@RequestBody ItemDetails item) {
		// Note, this only handles one item at a time, we need to have it handle multiple items at a single time
		// Note, this also does not receive the id of the actual item, so we have to manually put that in for now
		item.setItemId(1); // TESTING FOR NOW, HARD-CODED
		return itemDetailsRepo.save(item);
	}
	
	@PostMapping(path = "/item-details/receive")
	public String recieveItems(@RequestBody List<ItemDetails> items) {
		for (ItemDetails item : items) {
			try {
				item.setItemId(1); // TESTING FOR NOW, WILL CHANGE LATER
				itemDetailsRepo.save(item);
			} catch (Exception e) {
				return "Failed"; // THIS SHOULD PROBABLY BE A TRANSACTIONAL I BET!
			}
		}
		return "Success";
	}
	
	// Note, there is a bug with this, it automatically updates everything that is not set to null
	@PutMapping(path = "/item-details")
	public ItemDetails ItemDetails(@RequestBody ItemDetails item, @RequestParam Long id) {
		return itemDetailsRepo.findById(id).map(itemdetails -> {
			itemdetails.setLocation(item.getLocation());
			itemdetails.setOrderNumber(item.getOrderNumber());
			itemdetails.setExpiration(item.getExpiration());
			itemdetails.setDateReceived(item.getDateReceived());
			itemdetails.setDateShipped(item.getDateShipped());
			itemdetails.setDateDelivered(item.getDateDelivered());
			return itemDetailsRepo.save(itemdetails);
		}).orElseGet(() -> {
			System.out.println("We tried to update a item, but it didn't exist, so we are creating it");
			item.setItemId(1); // TESTING FOR NOW, HARD-CODED, NEED TO AUTOMATICALLY GET THIS
			return itemDetailsRepo.save(item);
		});
	}
}