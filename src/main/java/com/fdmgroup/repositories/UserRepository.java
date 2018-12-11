package com.fdmgroup.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	List<User> findByEmail(String email);
}

