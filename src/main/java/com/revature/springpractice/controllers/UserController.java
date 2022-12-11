package com.revature.springpractice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.springpractice.models.User;
import com.revature.springpractice.services.IUserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = ("/api"), produces = "application/json")

public class UserController {

    @Autowired
    private IUserService uServ;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {

        Optional<User> _user = uServ.getUserById(id);
        if (_user.isPresent()) {
            return new ResponseEntity<>(_user.get(), HttpStatus.CREATED);
        } else {
            ResponseEntity<User> r = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            return r;
        }

    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        try {
            int userRoleId = 1;
            User _user = uServ.registerUser(new User(user.getUserId(), user.getFirstName(), user.getLastName(),
                    user.getUsername(), user.getEmail(), user.getPassword(), userRoleId));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseEntity<User> r = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            return r;

        }
    }
}
