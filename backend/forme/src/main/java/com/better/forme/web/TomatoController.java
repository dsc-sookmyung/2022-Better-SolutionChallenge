package com.better.forme.web;

import com.better.forme.service.tomato.TomatoService;
import com.better.forme.web.dto.TomatoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TomatoController {
    private final TomatoService tomatoService;

    @GetMapping("/tomato/{id}")
    public TomatoResponseDto findById(@PathVariable Long id){
        return tomatoService.findById(id);
    }
}
