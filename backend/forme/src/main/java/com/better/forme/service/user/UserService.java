package com.better.forme.service.user;


import com.better.forme.domain.user.User;
import com.better.forme.domain.user.UserRepository;
import com.better.forme.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findById (Long user_key){
        User entity = userRepository.findById(user_key)
                .orElseThrow(()->new IllegalArgumentException("게시글노"));
        return new UserResponseDto(entity);
    }
}
