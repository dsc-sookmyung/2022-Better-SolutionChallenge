package com.better.forme.web.dto;

import com.better.forme.domain.main_page.MainPage;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class MainPageResponseDto {
    private Long id;

    // user
    private Integer day1;       //채식요일
    //, day2, day3, day4, day5, day6, day7;
    private Integer goalType;   //목표 채식 단계

    // tomato_character
    private Integer level;
    private Integer exp;

    // badge
    private Integer main_badge1;
    //, main_badge2, main_badge3;

    // diet_record
    private Date date;
    private String food_name;
    private String food_desc;
    // private *** 사진
    // private Integer meal_category;

    // recipe_record
    // private *** 완성사진
    private String recipe_name;
    private Integer type;
    private Integer cooking_time;

    // likes
    private Long likes;

    public MainPageResponseDto(MainPage entity) {
        this.id = entity.getId();
        this.day1 = entity.getDay1();
        this.goalType = entity.getGoalType();
        this.level = entity.getLevel();
        this.exp = entity.getExp();
        this.main_badge1 = entity.getMain_badge1();
        this.date = entity.getDate();
        this.food_name = entity.getFood_name();
        this.food_desc = entity.getFood_desc();
        this.recipe_name = entity.getRecipe_name();
        this.type = entity.getType();
        this.cooking_time = entity.getCooking_time();
        this.likes = entity.getLikes();
    }
}
