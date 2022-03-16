package com.better.forme.service.alarm;


import com.better.forme.domain.alarm.Alarm;
import com.better.forme.domain.alarm.AlarmRepository;
import com.better.forme.web.dto.AlarmDto.AlarmResponseDto;
import com.better.forme.web.dto.AlarmDto.AlarmSaveRequestDto;
import com.better.forme.web.dto.RecipeDto.RecipeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AlarmService {

    private final AlarmRepository alarmRepository;

    @Transactional
    public Long save(AlarmSaveRequestDto requestDto){
        return alarmRepository.save(requestDto.toEntity()).getUserId();
    }

    public AlarmResponseDto findById (Long id){
        Alarm entity = alarmRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("error"));
        return new AlarmResponseDto(entity);
    }
}
