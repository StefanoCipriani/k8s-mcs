package com.k8s.mcs.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.k8s.mcs.orders.repo.entity.Order;
import com.k8s.mcs.orders.service.OrderService;

@RestController
public class OrderController {

	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService){
		this.orderService = orderService;
	}

	
	@PostMapping(path="/add")
	public @ResponseBody String addNewOrder (@RequestParam String descr) {
		orderService.insertOrder(descr);
	
		return "Saved";
	}


	

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Order> getAllOrders() {
		return orderService.findAll();
	}
}
