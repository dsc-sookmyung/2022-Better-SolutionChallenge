package com.better.forme.domain.user;

import com.better.forme.domain.alarm.Alarm;
import com.better.forme.domain.badge.Badge;
import com.better.forme.domain.character.TomatoCharacter;
import com.better.forme.domain.diet_record.DietRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private Alarm alarm;

    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private Badge badge;

    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private TomatoCharacter tomatoCharacter;

    @Column(length = 500, nullable = false , name="id_email")
    private String idEmail;

    @Column(length = 500, nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean sex;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false ,name="current_type")
    private Integer currentType;

    @Column(nullable = false, name="goal_type")
    private Integer goalType;

    @Column(nullable = false)
    private Integer day1;

    private Integer day2, day3, day4, day5, day6, day7;

    @Column(nullable = false)
    private Time mealtime1;

    private Time mealtime2, mealtime3;

    @Column(nullable = false , name="on_alarm")
    private Boolean onAlarm;

    @Column(nullable = false)
    private String nickname;

    @Builder
    public User(Long userId, String idEmail, String email,
                Boolean sex, Integer age, Integer currentType, Integer goalType,
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
}
