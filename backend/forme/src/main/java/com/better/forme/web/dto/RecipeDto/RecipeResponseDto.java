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
    private String pic1;
    private String desc2;
    private String pic2;
    private String desc3;
    private String pic3;
    private String desc4;
    private String pic4;
    private String desc5;
    private String pic5;

    public RecipeResponseDto(RecipeRecord entity){
        this.id = entity.getId();
        this.recipe_name= entity.getRecipe_name();
        this.type= entity.getType();
        this.cooking_time= entity.getCooking_time();

        this.desc1 = entity.getDesc1();
        this.pic1 = entity.getPic1();
        this.desc2 = entity.getDesc2();
        this.pic2 = entity.getPic2();
        this.desc3 = entity.getDesc3();
        this.pic3 = entity.getPic3();
        this.desc4 = entity.getDesc4();
        this.pic4 = entity.getPic4();
        this.desc5 = entity.getPic5();
        this.pic5 = entity.getPic5();
    }
}
