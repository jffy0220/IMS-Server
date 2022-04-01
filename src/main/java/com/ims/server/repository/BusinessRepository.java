package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.server.model.Business;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Long> {

}
