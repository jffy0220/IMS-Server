package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.server.model.ItemDetails;

@Repository
public interface ItemDetailsRepository extends CrudRepository<ItemDetails, Long> {

}
