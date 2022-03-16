package com.better.forme.web.dto.AlarmDto;

import com.better.forme.domain.alarm.Alarm;
import com.better.forme.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
public class AlarmResponseDto {
    private Long userId;

    private Boolean day_alarm;
    private Boolean like_alarm;
    private Boolean recommend_alarm;
    private Boolean cheerup_alarm;
    private Integer mealtime_alarm;

    public AlarmResponseDto(Alarm entity){
        this.userId = entity.getUserId();
        this.day_alarm = entity.getDay_alarm();
        this.like_alarm =entity.getLike_alarm();
        this.recommend_alarm = entity.getRecommend_alarm();
        this.cheerup_alarm = entity.getCheerup_alarm();
        this.mealtime_alarm = entity.getMealtime_alarm();
    }
}
