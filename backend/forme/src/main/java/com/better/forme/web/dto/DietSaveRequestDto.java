package com.better.forme.web.dto;

import com.better.forme.domain.diet_record.DietRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class DietSaveRequestDto {

    private Date date;
    private Integer meal_category;
    private String food_name;
    private String food_desc;

    private Boolean egg_check;
    private Boolean dairy_check;
    private Boolean fish_check;
    private Boolean birds_check;
    private Boolean pork_check;
    private Boolean beef_check;

    @Builder
    public DietSaveRequestDto( Date date, Integer meal_category, String food_name, String food_desc, Boolean egg_check, Boolean dairy_check, Boolean fish_check, Boolean birds_check, Boolean pork_check, Boolean beef_check){
        this.date =getDate();
        this.meal_category=getMeal_category();
        this.food_name=getFood_name();
        this.food_desc=getFood_desc();
        this.egg_check=getEgg_check();
        this.dairy_check=getDairy_check();
        this.fish_check=getFish_check();
        this.birds_check=getBirds_check();
        this.pork_check=getPork_check();
        this.beef_check=getBeef_check();
    }

    public DietRecord toEntity(){
        return DietRecord.builder()
                .date(date)
                .meal_category(meal_category)
                .food_name(food_name)
                .food_desc(food_desc)
                .egg_check(egg_check)
                .dairy_check(dairy_check)
                .fish_check(fish_check)
                .birds_check(birds_check)
                .pork_check(pork_check)
                .beef_check(beef_check)
                .build();
    }
}
