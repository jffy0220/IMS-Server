package com.ims.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.server.model.Order;
import com.ims.server.repository.OrderRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import javassist.NotFoundException;

@RestController
@Api(tags = { "Order" })
@SwaggerDefinition(tags = { @Tag(name = "Order", description = "Operations for Managing an Order") })
public class OrderController {
	@Autowired
	private OrderRepository orderRepo;
	
	@GetMapping(name = "/order")
	public @ResponseBody Iterable<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	
	@GetMapping(name = "/order/{id}")
	public Order getOrder(@PathVariable("id") Long id) throws NotFoundException {
		return orderRepo.findById(id).orElseThrow(() -> new NotFoundException(null));
	}
	
	@PostMapping(name = "/order")
	public Order createOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}
}
