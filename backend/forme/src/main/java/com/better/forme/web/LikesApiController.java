package com.better.forme.web;

import com.better.forme.service.likes.LikesService;
import com.better.forme.web.dto.LikesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikesApiController {
    private final LikesService likesService;

    @GetMapping("/api/recipe-like/{index}")
    public LikesResponseDto findByIndex(@PathVariable Long index){
        return likesService.findByIndex(index);
    }
}
