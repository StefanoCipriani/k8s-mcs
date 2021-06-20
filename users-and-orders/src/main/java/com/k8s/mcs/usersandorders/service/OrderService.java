package com.k8s.mcs.usersandorders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.k8s.mcs.usersandorders.feign.UserClient;
import com.k8s.mcs.usersandorders.repo.entity.Order;
import com.k8s.mcs.usersandorders.repo.entity.User;
import com.k8s.mcs.usersandorders.repo.jpa.order.OrderRepository;
import com.k8s.mcs.usersandorders.repo.jpa.user.UserRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserClient userClient;

	@Transactional(rollbackFor = Exception.class, transactionManager = "orderTransactionManager") //Transaction works
	//@Transactional //Transaction does not work
	public void insertOrder(String descr) {
		Order o = new Order();
		o.setDescr(descr);
		orderRepository.save(o);
		
		User user = new User();
		user.setName("Utente_"+descr);
		user.setEmail(descr+"@mail.com");
		//int a = 1/0;
		userRepository.save(user);
		System.out.println(userClient.getAll());
	}

	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}
}
