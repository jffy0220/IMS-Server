package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.server.model.BusinessLocation;

@Repository
public interface BusinessLocationRepository extends CrudRepository<BusinessLocation, Long> {

}
