package com.k8s.mcs.usersandorders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.k8s.mcs.usersandorders.repo.entity.Order;
import com.k8s.mcs.usersandorders.service.OrderService;

@RestController
@RequestMapping("/user")
public class UserController {

	private OrderService orderService;
	
	@Autowired
	public UserController(OrderService orderService){
		this.orderService = orderService;
	}

	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String descr) {
		orderService.insertOrder(descr);
	
		return "Saved";
	}


	

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Order> getAllUsers() {
		return orderService.findAll();
	}
}
