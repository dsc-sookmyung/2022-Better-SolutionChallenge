package com.better.forme.service.badge;

import com.better.forme.domain.badge.Badge;
import com.better.forme.domain.badge.BadgeRepository;
import com.better.forme.web.dto.BadgeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BadgeService {
    private final BadgeRepository badgeRepository;

    public BadgeResponseDto findById (Long id){
        Badge entity = badgeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("error"));
        return new BadgeResponseDto(entity);
    }
}
