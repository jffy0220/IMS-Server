package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.BusinessLocation;
import com.ims.server.repository.BusinessLocationRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

@RestController
@Api(tags = { "BusinessLocation" })
@SwaggerDefinition(tags = { @Tag(name = "Business Location", description = "Operations for Managing a Business Location") })
public class BusinessLocationController {
	@Autowired
	private BusinessLocationRepository busLocRepo;
	
	@GetMapping(path = "/business/location")
	public @ResponseBody Iterable<BusinessLocation> getAllBusiness() {
		return busLocRepo.findAll();
	}
	
	@GetMapping(path = "/business/location/{id}")
	public BusinessLocation getBusinessLocation(@PathVariable("id") Long id) throws NotFoundException {
		return busLocRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@PostMapping(path = "/business/location")
	public BusinessLocation createBusinessLocation(@RequestBody BusinessLocation BusinessLocation) {
		return busLocRepo.save(BusinessLocation);
	}
}
