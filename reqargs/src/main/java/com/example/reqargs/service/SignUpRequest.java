package com.example.reqargs.service;

import com.example.reqargs.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class SignUpRequest {

    private final String email;
    private final String password;

    public Account toAccount() {
        return new Account(
                email, password
        );
    }
}
