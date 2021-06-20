package com.k8s.mcs.orders.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k8s.mcs.orders.feign.UserClient;
import com.k8s.mcs.orders.repo.entity.Order;
import com.k8s.mcs.orders.repo.jpa.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserClient userClient;
	
	@Transactional
	public void insertOrder(String descr) {
		Order o = new Order();
		o.setDescr(descr);
		orderRepository.save(o);
		
		//int a = 1/0;
		userClient.addUser("Utente_"+descr, descr+"@mail.com");
		System.out.println(userClient.getAll());
	}

	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}
}
