package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.server.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}