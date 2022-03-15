package com.better.forme.web.dto.UserDto;

import com.better.forme.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Getter
@NoArgsConstructor
public class UserInfoSaveRequestDto {

    private Long userId;
    private String idEmail;
    private String email;
    private Boolean sex;
    private Integer age;
    private Integer currentType;
    private Integer goalType;
    private Integer day1;
    private Integer day2, day3, day4, day5, day6, day7;
    private Time mealtime1;
    private Time mealtime2, mealtime3;
    private Boolean onAlarm;
    private String nickname;

    @Builder
    public UserInfoSaveRequestDto(Long userId,
     String idEmail, String email, Boolean sex, Integer age, Integer currentType, Integer goalType,
     Integer day1, Integer day2, Integer day3, Integer day4, Integer day5, Integer day6, Integer day7,
     Time mealtime1, Time mealtime2, Time mealtime3, Boolean onAlarm, String nickname) {
        this.userId = userId;
        this.idEmail = idEmail;
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.currentType = currentType;
        this.goalType = goalType;
        this.day1 = day1;
        this.day2 = day2;
        this.day3 = day3;
        this.day4 = day4;
        this.day5 = day5;
        this.day6 = day6;
        this.day7 = day7;
        this.mealtime1 = mealtime1;
        this.mealtime2 = mealtime2;
        this.mealtime3 = mealtime3;
        this.onAlarm = onAlarm;
        this.nickname = nickname;
    }

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .idEmail(idEmail)
                .email(email)
                .sex(sex)
                .age(age)
                .currentType(currentType)
                .goalType(goalType)
                .day1(day1).day2(day2).day3(day3).day4(day4).day5(day5).day6(day6).day7(day7)
                .mealtime1(mealtime1).mealtime2(mealtime2).mealtime3(mealtime3)
                .onAlarm(onAlarm)
                .nickname(nickname)
                .build();
    }
}
