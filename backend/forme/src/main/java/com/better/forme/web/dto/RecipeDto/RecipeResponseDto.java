package com.better.forme.web.dto.RecipeDto;

import com.better.forme.domain.recipe_record.RecipeRecord;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class RecipeResponseDto {
    private Long id;

    private String recipe_name;
    private Integer type;
    private Integer cooking_time;
    private String desc1;

    public RecipeResponseDto(RecipeRecord entity){
        this.id = entity.getId();
        this.recipe_name= entity.getRecipe_name();
        this.type= entity.getType();
        this.cooking_time= entity.getCooking_time();
        this.desc1 = entity.getDesc1();
    }
}
