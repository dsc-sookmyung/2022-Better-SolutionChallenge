package com.better.forme.web.dto;


import com.better.forme.domain.character.TomatoCharacter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TomatoResponseDto{
    private Long userId;
    private Integer level;

    public TomatoResponseDto(TomatoCharacter entity){
        this.userId= entity.getUserId();
        this.level= entity.getLevel();
    }
}