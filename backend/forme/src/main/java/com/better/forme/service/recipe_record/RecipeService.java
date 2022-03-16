package com.better.forme.service.recipe_record;

import com.better.forme.domain.recipe_record.RecipeRecord;
import com.better.forme.domain.recipe_record.RecipeRecordRepository;
import com.better.forme.web.dto.DietDto.DietSaveRequestDto;
import com.better.forme.web.dto.RecipeDto.RecipeResponseDto;
import com.better.forme.web.dto.RecipeDto.RecipeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeRecordRepository recipeRecordRepository;

    @Transactional
    public Long save(RecipeSaveRequestDto requestDto){
        return recipeRecordRepository.save(requestDto.toEntity()).getId();
    }

    public RecipeResponseDto findById (Long id){
        RecipeRecord entity = recipeRecordRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("no posts"));
        return new RecipeResponseDto(entity);
    }
}
