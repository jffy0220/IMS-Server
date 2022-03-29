package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.Location;
import com.ims.server.repository.LocationRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

/*
 * 
 * Note, we should probably update item details model to look for a location id, not name. And the location needs a foreign key id to the warehouse.
 */

@RestController
@Api(tags = { "Location" })
@SwaggerDefinition(tags = { @Tag(name = "Location", description = "Operations for managing locations") })
public class LocationController {
	@Autowired
	private LocationRepository locationRepo;
	
	@GetMapping(path = "/location")
	public @ResponseBody Iterable<Location> getAllLocations() {
		return locationRepo.findAll();
	}
	
	@GetMapping(path = "/location/single")
	public Location Location(@RequestParam Long id) throws NotFoundException {
		return locationRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@PostMapping(path = "/location")
	public Location createLocation(@RequestBody Location location) {
		return locationRepo.save(location);
	}
	
}
