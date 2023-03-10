package com.demo.springbootchat.user.service;

import com.demo.springbootchat.user.User;
import com.demo.springbootchat.user.data.UserCreate;
import com.demo.springbootchat.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(UserCreate userCreate) {
        userRepository.save(User.builder()
                .email(userCreate.email())
                .password(userCreate.password())
                .build());
    }
}
