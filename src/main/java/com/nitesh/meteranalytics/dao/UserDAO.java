package com.nitesh.meteranalytics.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nitesh.meteranalytics.models.User;


@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
	User findByUsername(String username);
}