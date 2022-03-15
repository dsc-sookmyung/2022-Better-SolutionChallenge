package com.better.forme.service.main_page;

import com.better.forme.domain.badge.Badge;
import com.better.forme.domain.badge.BadgeRepository;
import com.better.forme.domain.character.TomatoCharacter;
import com.better.forme.domain.character.TomatoCharacterRepository;
import com.better.forme.domain.diet_record.DietRecord;
import com.better.forme.domain.diet_record.DietRecordRepository;
import com.better.forme.domain.likes.LikesRepository;
import com.better.forme.domain.main_page.MainPage;
import com.better.forme.domain.recipe_record.RecipeRecord;
import com.better.forme.domain.recipe_record.RecipeRecordRepository;
import com.better.forme.domain.user.User;
import com.better.forme.domain.user.UserRepository;
import com.better.forme.web.dto.MainPageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class MainPageService {
    private final UserRepository userRepository;
    private final TomatoCharacterRepository tomatoCharacterRepository;
    private final BadgeRepository badgeRepository;
    private final DietRecordRepository dietRecordRepository;
    private final RecipeRecordRepository recipeRecordRepository;
    private final LikesRepository likesRepository;

    @Transactional
    public MainPageResponseDto findById (Long id) {

        // user 테이블 정보 가져옴
        User user_entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no user info"));
        Integer day1 = user_entity.getDay1();
        Integer goalType = user_entity.getGoalType();

        // tomato_character 테이블 정보 가져옴
        TomatoCharacter tomato_entity = tomatoCharacterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no user's character"));
        Integer level = tomato_entity.getLevel();
        Integer exp = tomato_entity.getExp();

        // badge 테이블 정보 가져옴
        Badge badge_entity = badgeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no user's badge"));
        Integer main_badge1 = badge_entity.getMain_badge1();

        // diet_record 테이블 정보 가져옴
        DietRecord dietRecord_entity = dietRecordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no user's diet record"));
        Date date = dietRecord_entity.getDate();
        String food_name = dietRecord_entity.getFood_name();
        String food_desc = dietRecord_entity.getFood_desc();

        // recipe_record 테이블 정보 가져옴
        RecipeRecord recipeRecord_entity = recipeRecordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no user's recipe record"));
        String recipe_name = recipeRecord_entity.getRecipe_name();
        Integer type = recipeRecord_entity.getType();
        Integer cooking_time = recipeRecord_entity.getCooking_time();

        // like 테이블 정보 가져옴
        //List<Likes> likes_entity = likesRepository.countRecipeLikes(1);
        Long likes = likesRepository.countRecipeLikes(Long.valueOf(1));

        MainPage mainPage = new MainPage(id, day1, goalType, level, exp, main_badge1,
                date, food_name, food_desc, recipe_name, type, cooking_time, likes);

        return new MainPageResponseDto(mainPage);
    }
}
