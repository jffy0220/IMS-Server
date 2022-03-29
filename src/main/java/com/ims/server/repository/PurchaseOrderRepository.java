package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.server.model.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Long> {

}
