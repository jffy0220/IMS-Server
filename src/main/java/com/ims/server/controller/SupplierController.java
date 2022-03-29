package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.Supplier;
import com.ims.server.repository.SupplierRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

@RestController
@Api(tags = { "Supplier" })
@SwaggerDefinition(tags = { @Tag(name = "Supplier", description = "Operations for Managing an Suppliers") })
public class SupplierController {

	@Autowired
	private SupplierRepository supplierRepo;
	
	@GetMapping(path = "/supplier")
	public @ResponseBody Iterable<Supplier> getAllSuppliers() {
		return supplierRepo.findAll();
	}
	
	@GetMapping(path = "/supplier/single")
	public Supplier supplier(@RequestParam Long id) throws NotFoundException {
		return supplierRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@PostMapping(path = "/supplier")
	public Supplier createSupplier(@RequestBody Supplier supplier) {
		return supplierRepo.save(supplier);
	}
	
	// Note, if you don't include all of the information here, it resets it to null, how can we fix this?
	@PutMapping(path = "/supplier")
	public Supplier updateSupplier(@RequestBody Supplier supplier, @RequestParam Long id) throws NotFoundException {
		Supplier sup = supplierRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
		sup.setPoc(supplier.getPoc());
		sup.setEmail(supplier.getEmail());
		sup.setPhoneOne(supplier.getPhoneOne());
		sup.setPhoneTwo(supplier.getPhoneTwo());
		return supplierRepo.save(sup);
	}
}
