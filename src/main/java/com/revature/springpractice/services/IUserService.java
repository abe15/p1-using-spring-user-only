package com.revature.springpractice.services;

import java.util.Optional;

import com.revature.springpractice.models.User;

public interface IUserService {

    public User registerUser(User user);

    public Optional<User> getUserById(int id);

}