package com.pweb.reddits.service;

import com.pweb.reddits.entity.User;
import com.pweb.reddits.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public Iterable<User> findAll() {
        return repo.findAll();
    }

    public void addUser(User user) {
        repo.save(user);
    }
}