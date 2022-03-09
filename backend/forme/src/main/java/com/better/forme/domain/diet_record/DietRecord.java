package com.better.forme.domain.diet_record;

import com.better.forme.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class DietRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Integer meal_category;

    @Column(nullable = false)
    private String food_name;

    @Column(nullable = false, length = 500)
    private String food_desc;

    @Column(nullable = false)
    private Boolean egg_check;

    @Column(nullable = false)
    private Boolean dairy_check;

    @Column(nullable = false)
    private Boolean fish_check;

    @Column(nullable = false)
    private Boolean birds_check;

    @Column(nullable = false)
    private Boolean pork_check;

    @Column(nullable = false)
    private Boolean beef_check;

    @Builder
    public DietRecord(Date date, Integer meal_category, String food_name, String food_desc, Boolean egg_check, Boolean dairy_check, Boolean fish_check, Boolean birds_check, Boolean pork_check, Boolean beef_check) {
        this.date =date;
        this.meal_category=meal_category;
        this.food_name=food_name;
        this.food_desc=food_desc;
        this.egg_check=egg_check;
        this.dairy_check=dairy_check;
        this.fish_check=fish_check;
        this.birds_check=birds_check;
        this.pork_check=pork_check;
        this.beef_check=beef_check;
    }
}
