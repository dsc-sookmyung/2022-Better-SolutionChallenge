package com.better.forme.web;

import com.better.forme.service.badge.BadgeService;
import com.better.forme.web.dto.BadgeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BadgeApiController {
    private final BadgeService badgeService;

    @GetMapping("/api/badge/{id}")
    public BadgeResponseDto findById(@PathVariable Long id){
        return badgeService.findById(id);
    }

}
