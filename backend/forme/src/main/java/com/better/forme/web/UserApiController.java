package com.better.forme.web;

import com.better.forme.domain.user.User;
import com.better.forme.domain.user.UserRepository;
import com.better.forme.service.user.UserService;
import com.better.forme.web.dto.UserDto.UserInfoSaveRequestDto;
import com.better.forme.web.dto.UserDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("api/user/sign-up")
    public Long save(@RequestBody UserInfoSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @GetMapping("/api/user")
    public List<User> retrieveAllUsers(){
        return userRepository.findAllDesc_User();
    }

    @GetMapping("/api/user/{id}")
    public UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }
}
