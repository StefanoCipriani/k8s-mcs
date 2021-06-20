package com.k8s.mcs.usersandorders.repo.jpa.order;

import org.springframework.data.repository.CrudRepository;

import com.k8s.mcs.usersandorders.repo.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
