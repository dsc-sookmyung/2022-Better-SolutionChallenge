package com.better.forme.web;


import com.better.forme.domain.diet_record.DietRecord;
import com.better.forme.domain.diet_record.DietRecordRepository;
import com.better.forme.domain.user.User;
import com.better.forme.domain.user.UserRepository;
import com.better.forme.service.diet_record.DietService;
import com.better.forme.web.dto.DietDto.DietResponseDto;
import com.better.forme.web.dto.DietDto.DietSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class DietApiController {

    private final DietService dietService;

    private final UserRepository userRepository;
    private final DietRecordRepository dietRecordRepository;

    @PostMapping("/api/diet")
    public Long save(@RequestBody DietSaveRequestDto requestDto) {
        return dietService.save(requestDto);
    }

    @GetMapping("/api/diet/{id}")
    public DietResponseDto findById(@PathVariable Long id){
        return dietService.findById(id);
    }

    @GetMapping("/api/user/{userid}/diet-record")
    public List<DietRecord> retrieveAllDietRecordByUser(@PathVariable Long userid){
        Optional<User> user = userRepository.findById(userid);
        if(!user.isPresent()){
            throw new IllegalArgumentException(String.format("ID[%s] not found",userid));
        }
        return dietRecordRepository.findDietRecordUser(userid);
    }

    @GetMapping("/api/user/{userid}/diet-record/{id}")
    public List<DietRecord> OneDietRecordByUser(@PathVariable Long userid, @PathVariable Long id){
        Optional<User> user = userRepository.findById(userid);
        if(!user.isPresent()){
            throw new IllegalArgumentException(String.format("ID[%s] not found",userid));
        }
        return dietRecordRepository.findOneDietRecordUser(userid,id);
    }
}
