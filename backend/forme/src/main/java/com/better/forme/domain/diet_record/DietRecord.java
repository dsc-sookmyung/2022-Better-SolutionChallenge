package com.better.forme.domain.diet_record;

import com.better.forme.domain.user.User;
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
    private Long diet_index;

    @OneToOne
    @JoinColumn(name = "user_key", nullable = false)
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
}
