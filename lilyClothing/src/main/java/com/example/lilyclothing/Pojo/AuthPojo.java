package com.example.lilyclothing.Pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthPojo {
    private String username;
    private String password;

    public AuthPojo(String username, String password) {
    }
}
