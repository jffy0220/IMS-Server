package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}