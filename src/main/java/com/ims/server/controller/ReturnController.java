package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.Return;
import com.ims.server.repository.ReturnRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

@RestController
@Api(tags = { "Return" })
@SwaggerDefinition(tags = { @Tag(name = "Return", description = "Operations for Managing a Return") })
public class ReturnController {
	@Autowired
	private ReturnRepository returnRepo;
	
	@GetMapping(path = "/return")
	public @ResponseBody Iterable<Return> getAllReturns() {
		return returnRepo.findAll();
	}
	
	@GetMapping(path = "/return/{id}")
	public Return getReturn(@PathVariable("id") Long id) throws NotFoundException {
		return returnRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@PostMapping(path = "/return")
	public Return createReturn(@RequestBody Return returns) {
		return returnRepo.save(returns);
	}
	
	// WE WILL NEED TO CREATE THE CAPABILITY TO HANDLE MULTIPLE RETURNS AT ONCE
}
