package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.BusinessOrder;
import com.ims.server.repository.BusinessOrderRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

@RestController
@Api(tags = { "BusinessOrder" })
@SwaggerDefinition(tags = { @Tag(name = "Business Order", description = "Operations for Managing a Business Order") })
public class BusinessOrderController {
	@Autowired
	private BusinessOrderRepository busOrderRepo;
	
	@GetMapping(path = "/business")
	public @ResponseBody Iterable<BusinessOrder> getAllBusiness() {
		return busOrderRepo.findAll();
	}
	
	@GetMapping(path = "/business/{id}")
	public BusinessOrder getBusinessOrder(@PathVariable("id") Long id) throws NotFoundException {
		return busOrderRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@PostMapping(path = "/business")
	public BusinessOrder createBusiness(@RequestBody BusinessOrder business) {
		return busOrderRepo.save(business);
	}
}
