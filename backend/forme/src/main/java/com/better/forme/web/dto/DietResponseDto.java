package com.better.forme.web.dto;

import com.better.forme.domain.diet_record.DietRecord;
import com.better.forme.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Getter
@NoArgsConstructor
public class DietResponseDto {
    private Long id;

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

    public DietResponseDto(DietRecord entity){
        this.id = entity.getId();
        this.date =entity.getDate();
        this.meal_category=entity.getMeal_category();
        this.food_name=entity.getFood_name();
        this.food_desc=entity.getFood_desc();
        this.egg_check=entity.getEgg_check();
        this.dairy_check=entity.getDairy_check();
        this.fish_check=entity.getFish_check();
        this.birds_check=entity.getBirds_check();
        this.pork_check=entity.getPork_check();
        this.beef_check=entity.getBeef_check();
    }
}
