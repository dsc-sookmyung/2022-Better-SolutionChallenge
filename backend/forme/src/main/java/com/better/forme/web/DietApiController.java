package com.better.forme.web;


import com.better.forme.service.diet_record.DietService;
import com.better.forme.web.dto.DietResponseDto;
import com.better.forme.web.dto.DietSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DietApiController {

    private final DietService dietService;

    @PostMapping("/api/diet")
    public Long save(@RequestBody DietSaveRequestDto requestDto) {
        return dietService.save(requestDto);
    }

    @GetMapping("/api/diet/{id}")
    public DietResponseDto findById(@PathVariable Long id){
        return dietService.findById(id);
    }
}
