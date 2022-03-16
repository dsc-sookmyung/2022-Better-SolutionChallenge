package com.better.forme.web.dto;

import com.better.forme.domain.diet_record.DietRecord;
import com.better.forme.domain.main_page.MainPage;
import com.better.forme.domain.recipe_record.RecipeRecord;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class MainPageResponseDto {
    private Long id;

    // user
    private Integer day1;//, day2, day3, day4, day5, day6, day7;       //채식요일
    private Integer goalType;   //목표 채식 단계

    // tomato_character
    private Integer level;
    private Integer exp;

    // badge
    private Integer main_badge1;//, main_badge2, main_badge3;

    // diet_record
    private List<DietRecord> dietRecords;

    // recipe_record
    private List<RecipeRecord> recipeRecords;

    // likes
    private Long likes;

    public MainPageResponseDto(MainPage entity) {
        this.id = entity.getId();
        this.day1 = entity.getDay1();
        this.goalType = entity.getGoalType();
        this.level = entity.getLevel();
        this.exp = entity.getExp();
        this.main_badge1 = entity.getMain_badge1();
        this.dietRecords = entity.getDietRecords();
        this.recipeRecords = entity.getRecipeRecords();
        this.likes = entity.getLikes();
    }
}
