package ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ims.models.Item;
import ims.repository.ItemRepository;

@RestController
// @Api(tags = { "Item" })
// @SwaggerDefinition(tags = { @tag(name = "Item", description = "Operations for Managing an Item") })
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepo;

	@GetMapping("/item")
	// @ApiOperation(value = "List all items")
	public List<Item> getCollections() {
		return itemRepo.findByDateDeletedIsNull();
	}
}
