package com.better.forme.service.diet_record;

import com.better.forme.domain.diet_record.DietRecord;
import com.better.forme.domain.diet_record.DietRecordRepository;
import com.better.forme.domain.user.User;
import com.better.forme.web.dto.DietDto.DietResponseDto;
import com.better.forme.web.dto.DietDto.DietSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
