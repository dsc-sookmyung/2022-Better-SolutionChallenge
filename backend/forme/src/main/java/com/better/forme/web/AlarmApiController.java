package com.better.forme.web;

import com.better.forme.service.alarm.AlarmService;
import com.better.forme.web.dto.AlarmResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AlarmApiController {
    private final AlarmService alarmService;

    @GetMapping("/api/alarm/{id}")
    public AlarmResponseDto findById(@PathVariable Long id){
        return alarmService.findById(id);
    }
}
