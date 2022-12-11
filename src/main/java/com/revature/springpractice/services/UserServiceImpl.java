package com.revature.springpractice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.springpractice.dao.UserDao;
import com.revature.springpractice.models.User;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User registerUser(User user) {
        return userDao.save(user);

    }

    @Override
    public Optional<User> getUserById(int id) {
        // TODO Auto-generated method stub
        return userDao.findByUserId(id);
    }

}
