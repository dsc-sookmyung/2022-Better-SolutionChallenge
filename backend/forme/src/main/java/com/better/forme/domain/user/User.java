package com.better.forme.domain.user;

import com.better.forme.domain.alarm.Alarm;
import com.better.forme.domain.badge.Badge;
import com.better.forme.domain.character.TomatoCharacter;
import com.better.forme.domain.diet_record.DietRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "user")
//    private List<Alarm> alarm;
//
//    @OneToOne(mappedBy = "user")
//    private Badge badge;
//
//    @OneToOne(mappedBy = "user")
//    private TomatoCharacter tomatoCharacter;

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

}
