package com.better.forme.web;

import com.better.forme.domain.recipe_record.RecipeRecord;
import com.better.forme.domain.recipe_record.RecipeRecordRepository;
import com.better.forme.domain.user.User;
import com.better.forme.domain.user.UserRepository;
import com.better.forme.service.recipe_record.RecipeService;
import com.better.forme.web.dto.DietDto.DietSaveRequestDto;
import com.better.forme.web.dto.RecipeDto.RecipeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class RecipeApiController {

    private final RecipeService recipeService;

    private final UserRepository userRepository;
    private final RecipeRecordRepository recipeRecordRepository;

    @PostMapping("/api/recipe-record")
    public Long save(@RequestBody RecipeSaveRequestDto requestDto) {
        return recipeService.save(requestDto);
    }

    @GetMapping("/api/user/{userid}/recipe-record/{id}")
    public List<RecipeRecord> OneRecipeRecordByUser(@PathVariable Long userid, @PathVariable Long id ){
        Optional<User> user = userRepository.findById(userid);
        if(!user.isPresent()){
            throw new IllegalArgumentException(String.format("ID[%s] not found", userid));
        }
        return recipeRecordRepository.findOneRecipeRecordUser(userid,id);
    }
}
