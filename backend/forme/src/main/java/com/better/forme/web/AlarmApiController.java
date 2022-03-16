package com.better.forme.web;

import com.better.forme.service.alarm.AlarmService;
import com.better.forme.web.dto.AlarmDto.AlarmResponseDto;
import com.better.forme.web.dto.AlarmDto.AlarmSaveRequestDto;
import com.better.forme.web.dto.RecipeDto.RecipeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AlarmApiController {

    private final AlarmService alarmService;

    @PostMapping("/api/setting/alarm")
    public Long save(@RequestBody AlarmSaveRequestDto requestDto) {
        return alarmService.save(requestDto);
    }

    @GetMapping("/api/setting/alarm/{id}")
    public AlarmResponseDto findById(@PathVariable Long id){
        return alarmService.findById(id);
    }
}
