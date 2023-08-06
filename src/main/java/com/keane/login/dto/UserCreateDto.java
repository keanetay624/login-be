package com.keane.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreateDto {
    private String userName;
    private String password;
    private String fullName;
    private int isManager;
}
