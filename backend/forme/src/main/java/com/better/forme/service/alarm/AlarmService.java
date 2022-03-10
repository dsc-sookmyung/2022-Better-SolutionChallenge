package com.better.forme.service.alarm;


import com.better.forme.domain.alarm.Alarm;
import com.better.forme.domain.alarm.AlarmRepository;
import com.better.forme.web.dto.AlarmResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AlarmService {
    private final AlarmRepository alarmRepository;

    public AlarmResponseDto findById (Long id){
        Alarm entity = alarmRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("error"));
        return new AlarmResponseDto(entity);
    }
}
