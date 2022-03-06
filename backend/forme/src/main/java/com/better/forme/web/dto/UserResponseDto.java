package com.better.forme.web.dto;

import com.better.forme.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String nickname;

    public UserResponseDto(User entity){
        this.id = entity.getId();
        this.nickname = entity.getNickname();

    }
}
