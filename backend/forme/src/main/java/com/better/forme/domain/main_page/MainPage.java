package com.better.forme.domain.main_page;

import com.better.forme.domain.diet_record.DietRecord;
import com.better.forme.domain.recipe_record.RecipeRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    private List<DietRecord> dietRecords;

    // recipe_record
    private List<RecipeRecord> recipeRecords;

    // likes
    private Long likes;

    @Builder
    public MainPage(Long id, Integer day1, Integer goalType,
                    Integer level, Integer exp,
                    Integer main_badge1,
                    List<DietRecord> dietRecords, List<RecipeRecord> recipeRecords, Long likes) {

        this.id = id;
        this.day1 = day1;
        this.goalType = goalType;
        this.level = level;
        this.exp = exp;
        this.main_badge1 = main_badge1;
        this.dietRecords = dietRecords;
        this.recipeRecords = recipeRecords;
        this.likes = likes;
    }
}
