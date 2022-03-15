package com.better.forme.web.dto.DietDto;

import com.better.forme.domain.diet_record.DietRecord;
import com.better.forme.domain.user.User;
import com.better.forme.domain.user.UserRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class DietSaveRequestDto {

    private User user;

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
    public DietSaveRequestDto(User user, Date date, Integer meal_category, String food_name, String food_desc,
                              Boolean egg_check, Boolean dairy_check, Boolean fish_check, Boolean birds_check, Boolean pork_check, Boolean beef_check){


        this.user = user;
        this.date = date;
        this.meal_category= meal_category;
        this.food_name= food_name;
        this.food_desc=food_desc;
        this.egg_check=egg_check;
        this.dairy_check=dairy_check;
        this.fish_check=fish_check;
        this.birds_check=birds_check;
        this.pork_check=pork_check;
        this.beef_check=beef_check;
    }

    public DietRecord toEntity(){
        return DietRecord.builder()
                .user(user)
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
