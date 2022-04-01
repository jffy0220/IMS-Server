package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.server.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
