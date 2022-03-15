package com.better.forme.service.likes;

import com.better.forme.domain.likes.Likes;
import com.better.forme.domain.likes.LikesRepository;
import com.better.forme.web.dto.LikesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository likesRepository;

    public LikesResponseDto findByIndex(Long index){
        Likes entity = likesRepository.findById(index)
                .orElseThrow(()->new IllegalArgumentException("error"));
        return new LikesResponseDto(entity);
    }
}
