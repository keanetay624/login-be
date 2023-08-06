package com.keane.login.controller;

import com.keane.login.dto.ApiResponse;
import com.keane.login.dto.UserDto;
import com.keane.login.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {
    private final UserEntityService userService;

    @GetMapping("/{username}")
    public ApiResponse getEmployeeByUsername(@PathVariable String username) {
        UserDto user = userService.findUserByUsername(username);
        return new ApiResponse.ApiResponseBuilder(HttpStatus.OK)
                .setData(user)
                .build();
    }

    @GetMapping("/getAll")
    public ApiResponse getAllEmployees() {
        List<UserDto> users = userService.getAllUsers();
        return new ApiResponse.ApiResponseBuilder(HttpStatus.OK)
                .setData(users)
                .build();
    }
}
