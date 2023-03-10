package com.demo.springbootchat.user.controller;

import com.demo.springbootchat.user.data.UserCreate;
import com.demo.springbootchat.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/users")
    public void signup(@RequestBody UserCreate userCreate) {
        userService.save(userCreate);
    }

    @PostMapping("/api/v1/login")
    public void login() {
    }
}
