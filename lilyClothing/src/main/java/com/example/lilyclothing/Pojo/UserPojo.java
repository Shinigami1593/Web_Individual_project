package com.example.lilyclothing.Pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserPojo {

    private Long id;
    private String username;
    private String password;
    private String address;
    private Long phone ;
}
