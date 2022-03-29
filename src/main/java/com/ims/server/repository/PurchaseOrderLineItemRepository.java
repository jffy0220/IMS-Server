package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.server.model.PurchaseOrderLineItems;

@Repository
public interface PurchaseOrderLineItemRepository extends CrudRepository<PurchaseOrderLineItems, Long>{

}
