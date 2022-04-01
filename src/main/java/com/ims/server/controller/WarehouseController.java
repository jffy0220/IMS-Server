package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.Warehouse;
import com.ims.server.repository.WarehouseRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

@RestController
@Api(tags = { "User" })
@SwaggerDefinition(tags = { @Tag(name = "User", description = "Operations for Managing a User") })
public class WarehouseController {
	
	@Autowired
	private WarehouseRepository warehouseRepo;
	
	@GetMapping(path = "/warehouse")
	public @ResponseBody Iterable<Warehouse> getAllWarehouses() {
		return warehouseRepo.findAll();
	}
	
	@GetMapping(path = "/warehouse/{id}")
	public Warehouse getWarehouse(@PathVariable("id") Long id) throws NotFoundException {
		return warehouseRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@PostMapping(path = "/warehouse")
	public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
		return warehouseRepo.save(warehouse);
	}
}
