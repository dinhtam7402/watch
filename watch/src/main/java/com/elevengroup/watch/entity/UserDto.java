package com.elevengroup.watch.entity;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String role;
}
