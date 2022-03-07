package com.better.forme.domain.main_page;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class MainPage {

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

    @Builder
    public MainPage(Long id, Integer day1, Integer goalType,
                    Integer level, Integer exp,
                    Integer main_badge1,
                    Date date, String food_name, String food_desc,
                    String recipe_name, Integer type, Integer cooking_time, Long likes) {

        this.id = id;
        this.day1 = day1;
        this.goalType = goalType;
        this.level = level;
        this.exp = exp;
        this.main_badge1 = main_badge1;
        this.date = date;
        this.food_name = food_name;
        this.food_desc = food_desc;
        this.recipe_name = recipe_name;
        this.type = type;
        this.cooking_time = cooking_time;
        this.likes = likes;
    }
}
