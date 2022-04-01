package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.Business;
import com.ims.server.repository.BusinessRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

@RestController
@Api(tags = { "Business" })
@SwaggerDefinition(tags = { @Tag(name = "Business", description = "Operations for Managing a Business") })
public class BusinessController {
	@Autowired
	private BusinessRepository busRepo;
	
	@GetMapping(path = "/business")
	public @ResponseBody Iterable<Business> getAllBusiness() {
		return busRepo.findAll();
	}
	
	@GetMapping(path = "/business/{id}")
	public Business getBusiness(@PathVariable("id") Long id) throws NotFoundException {
		return busRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@PostMapping(path = "/business")
	public Business createBusiness(@RequestBody Business business) {
		return busRepo.save(business);
	}
}
