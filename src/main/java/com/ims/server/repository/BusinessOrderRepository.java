package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.server.model.BusinessOrder;

@Repository
public interface BusinessOrderRepository extends CrudRepository<BusinessOrder, Long> {

}
