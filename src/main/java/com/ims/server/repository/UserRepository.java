package com.ims.server.repository;

import org.springframework.data.repository.CrudRepository;

import com.ims.server.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
