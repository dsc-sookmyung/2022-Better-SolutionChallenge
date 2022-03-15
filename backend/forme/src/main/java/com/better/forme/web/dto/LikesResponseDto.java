package com.better.forme.web.dto;

import com.better.forme.domain.likes.Likes;
import com.better.forme.domain.recipe_record.RecipeRecord;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class LikesResponseDto {
    private Long likes_index;

    private RecipeRecord recipe_record_index;
    private Boolean likes;

    public LikesResponseDto(Likes entity){
        this.likes_index = entity.getLikes_index();
        this.recipe_record_index =entity.getRecipe_record_index();
        this.likes=entity.getLikes();
    }
}
