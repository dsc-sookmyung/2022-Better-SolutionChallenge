package com.better.forme.domain.alarm;

import com.better.forme.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
public class Alarm implements Serializable {

    @Id
    private Long userId;

    @MapsId("userId")  //Alarm.userId 매핑
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Boolean day_alarm;

    @Column(nullable = false)
    private Boolean like_alarm;

    @Column(nullable = false)
    private Boolean recommend_alarm;

    @Column(nullable = false)
    private Boolean cheerup_alarm;

    @Column(nullable = false)
    private Integer mealtime_alarm;

    @Builder
    public Alarm(User user, Boolean day_alarm, Boolean like_alarm, Boolean recommend_alarm, Boolean cheerup_alarm, Integer mealtime_alarm) {
        this.user = user;
        this.day_alarm = day_alarm;
        this.like_alarm = like_alarm;
        this.recommend_alarm = recommend_alarm;
        this.cheerup_alarm = cheerup_alarm;
        this.mealtime_alarm = mealtime_alarm;
    }
}
