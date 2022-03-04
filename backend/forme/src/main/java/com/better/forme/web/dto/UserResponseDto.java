package com.better.forme.web.dto;

import com.better.forme.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long user_key;
    private String nickname;

    public UserResponseDto(User entity){
        this.user_key = entity.getUser_key();
        this.nickname = entity.getNickname();

    }
}
