package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.server.model.Supplier;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

}
