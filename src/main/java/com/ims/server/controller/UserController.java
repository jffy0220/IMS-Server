package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.User;
import com.ims.server.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

// NOTE: When we return a user, we should not include the password hash in it...

@RestController
@Api(tags = { "User" })
@SwaggerDefinition(tags = { @Tag(name = "User", description = "Operations for Managing a User") })
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping(path = "/user")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping(path = "/user/{id}")
	public User getUser(@PathVariable("id") Long id) throws NotFoundException {
		return userRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@PostMapping(path = "/user")
	public User createUser(@RequestBody User user) {
		return userRepo.save(user); 
	}
}
