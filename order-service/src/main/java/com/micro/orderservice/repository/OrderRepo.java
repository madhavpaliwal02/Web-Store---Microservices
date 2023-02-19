package com.micro.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.orderservice.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
