package com.better.forme.service.diet_record;

import com.better.forme.domain.diet_record.DietRecord;
import com.better.forme.domain.diet_record.DietRecordRepository;
import com.better.forme.web.dto.DietResponseDto;
import com.better.forme.web.dto.DietSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class DietService {
    private final DietRecordRepository dietRecordRepository;

    @Transactional
    public Long save(DietSaveRequestDto requestDto){
        return dietRecordRepository.save(requestDto.toEntity()).getId();
    }

    public DietResponseDto findById (Long id){
        DietRecord entity = dietRecordRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("no posts"));
        return new DietResponseDto(entity);
    }
}
