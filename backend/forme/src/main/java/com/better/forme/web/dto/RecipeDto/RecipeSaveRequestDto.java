package com.better.forme.web.dto.RecipeDto;

import com.better.forme.domain.recipe_record.RecipeRecord;
import com.better.forme.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class RecipeSaveRequestDto {

    private User user;
    private String recipe_name;
    private Integer type;
    private Integer cooking_time;
    private String desc1;
    private String desc2;
    private String desc3;
    private String desc4;
    private String desc5;

    @Builder
    public RecipeSaveRequestDto(User user, String recipe_name, Integer type, Integer cooking_time,
                        String desc1, String desc2, String desc3, String desc4, String desc5){
        this.user = user;
        this.recipe_name = recipe_name;
        this.type = type;
        this.cooking_time = cooking_time;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;
        this.desc4 = desc4;
        this.desc5 = desc5;
    }

    public RecipeRecord toEntity(){
        return RecipeRecord.builder()
                .user(user)
                .recipe_name(recipe_name)
                .type(type)
                .cooking_time(cooking_time)
                .desc1(desc1)
                .desc2(desc2)
                .desc3(desc3)
                .desc4(desc4)
                .desc5(desc5)
                .build();
    }
}
