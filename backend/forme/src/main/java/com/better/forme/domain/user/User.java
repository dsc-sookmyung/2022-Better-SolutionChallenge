package com.better.forme.domain.user;

import com.better.forme.domain.alarm.Alarm;
import com.better.forme.domain.badge.Badge;
import com.better.forme.domain.character.TomatoCharacter;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Data
public class User {

    @Id
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_key;

//    @OneToMany(mappedBy = "user")
//    private List<Alarm> alarm;
//
//    @OneToOne(mappedBy = "user")
//    private Badge badge;
//
//    @OneToOne(mappedBy = "user")
//    private TomatoCharacter tomatoCharacter;

    @Column(length = 500, nullable = false)
    private String id;

    @Column(length = 500, nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean sex;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Integer current_type, goal_type;

    @Column(nullable = false)
    private Integer day1;

    private Integer day2, day3, day4, day5, day6, day7;

    @Column(nullable = false)
    private Time mealtime1;

    private Time mealtime2, mealtime3;

    @Column(nullable = false)
    private Boolean on_alarm;

    @Column(nullable = false)
    private String nickname;
}
