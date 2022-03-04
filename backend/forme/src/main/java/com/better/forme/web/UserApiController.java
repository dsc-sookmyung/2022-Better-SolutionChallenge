package com.better.forme.web;

import com.better.forme.service.user.UserService;
import com.better.forme.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @GetMapping("/api/user/{user_key}")
    public UserResponseDto findById(@PathVariable Long user_key){
        return userService.findById(user_key);
    }
}
