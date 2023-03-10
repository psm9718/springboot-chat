package com.demo.springbootchat.user.data;

import lombok.Builder;

public record UserCreate(String email, String password) {
    @Builder
    public UserCreate {
    }
}
