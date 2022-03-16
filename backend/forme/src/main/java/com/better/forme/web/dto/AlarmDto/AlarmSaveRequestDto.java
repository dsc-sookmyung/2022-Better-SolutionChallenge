package com.better.forme.web.dto.AlarmDto;

import com.better.forme.domain.alarm.Alarm;
import com.better.forme.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class AlarmSaveRequestDto {

    private User user;
    private Boolean day_alarm;
    private Boolean like_alarm;
    private Boolean recommend_alarm;
    private Boolean cheerup_alarm;
    private Integer mealtime_alarm;

    @Builder
    public AlarmSaveRequestDto(User user, Boolean day_alarm, Boolean like_alarm,
                               Boolean recommend_alarm, Boolean cheerup_alarm, Integer mealtime_alarm) {
        this.user = user;
        this.day_alarm = day_alarm;
        this.like_alarm = like_alarm;
        this.recommend_alarm = recommend_alarm;
        this.cheerup_alarm = cheerup_alarm;
        this.mealtime_alarm = mealtime_alarm;
    }

    public Alarm toEntity() {
        return Alarm.builder()
                .user(user)
                .day_alarm(day_alarm)
                .like_alarm(like_alarm)
                .recommend_alarm(recommend_alarm)
                .cheerup_alarm(cheerup_alarm)
                .mealtime_alarm(mealtime_alarm)
                .build();
    }
}
