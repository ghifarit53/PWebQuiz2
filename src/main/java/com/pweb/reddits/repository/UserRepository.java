package com.pweb.reddits.repository;

import org.springframework.data.repository.CrudRepository;
import  com.pweb.reddits.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
}
