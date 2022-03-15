package com.better.forme.service.tomato;

import com.better.forme.domain.character.TomatoCharacter;
import com.better.forme.domain.character.TomatoCharacterRepository;
import com.better.forme.web.dto.TomatoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TomatoService {
    private final  TomatoCharacterRepository tomatoCharacterRepository;
    public TomatoResponseDto findById (Long id){
        TomatoCharacter entity = tomatoCharacterRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("error"));
        return new TomatoResponseDto(entity);
    }
}
