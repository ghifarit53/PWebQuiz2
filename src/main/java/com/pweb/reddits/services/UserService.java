package com.pweb.reddits.services;

import com.pweb.reddits.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<User>();

    public List<User> findAll() {
        return users;
    }

    public void addUser(User user) {
        user.setId(System.currentTimeMillis());
        users.add(user);
    }
}