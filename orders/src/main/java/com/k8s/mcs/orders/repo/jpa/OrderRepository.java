package com.k8s.mcs.orders.repo.jpa;

import org.springframework.data.repository.CrudRepository;

import com.k8s.mcs.orders.repo.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
