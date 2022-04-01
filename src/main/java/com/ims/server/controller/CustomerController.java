package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.Customer;
import com.ims.server.repository.CustomerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

@RestController
@Api(tags = { "Customer" })
@SwaggerDefinition(tags = { @Tag(name = "Customer", description = "Operations for Managing Customers") })
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@GetMapping(path = "/customer")
	public @ResponseBody Iterable<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	
	@GetMapping(path = "/customer/{id}")
	public Customer getCustomer(@PathVariable("id") Long id) throws NotFoundException {
		return customerRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@PostMapping(path = "/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
}
