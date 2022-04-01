package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.server.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
