package com.better.forme.web;

import com.better.forme.service.main_page.MainPageService;
import com.better.forme.web.dto.MainPageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainPageController {

    private final MainPageService mainPageService;

    @GetMapping("/api/main/{id}")
    public MainPageResponseDto findById(@PathVariable Long id){
        return mainPageService.findById(id);
    }
}
