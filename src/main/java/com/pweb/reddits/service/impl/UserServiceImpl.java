package com.pweb.reddits.service.impl;

import com.pweb.reddits.entity.Users;
import com.pweb.reddits.repository.UserRepository;
import com.pweb.reddits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository

    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) userRepository.findAll();
    }

    @Override
    public Users getUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Users addOrUpdateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users deleteUser(int userId) {
        Users deletedUser = null;
        try{
            deletedUser = userRepository.findById(userId).orElse(null);
            if(deletedUser = null){
                throw new Exception("user not available");
            }
            else{
                userRepository.deleteById(userId);
            }
        }
        catch(Exception ex){
            throw ex;
        }
        return deletedUser;
    }
}
