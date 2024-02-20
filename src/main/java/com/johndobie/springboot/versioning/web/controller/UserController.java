package com.johndobie.springboot.versioning.web.controller;

import com.johndobie.springboot.versioning.web.model.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Validated
public class UserController {

    HashMap<Integer, User> users = new HashMap<>();

    public static final String GET_USER_MODEL_ENDPOINT = "/user";
    public static final String SAVE_USER_MODEL_ENDPOINT = "/user";

    @GetMapping(value = GET_USER_MODEL_ENDPOINT)
    public User getUser(@RequestParam Integer id) {
        return users.get(id);
    }

    @PostMapping(value = SAVE_USER_MODEL_ENDPOINT)
    public User saveUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return user;
    }
}