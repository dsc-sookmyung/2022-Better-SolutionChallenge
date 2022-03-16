package com.better.forme.domain.recipe_record;

import com.better.forme.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class RecipeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String recipe_name;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false)
    private Integer cooking_time;

    @Column(nullable = false)
    private String desc1;

    @Column(nullable = false, length = 500)
    private String pic1;

    private String desc2;

    @Column(length = 500)
    private String pic2;

    private String desc3;

    @Column(length = 500)
    private String pic3;

    private String desc4;

    @Column(length = 500)
    private String pic4;

    private String desc5;

    @Column(length = 500)
    private String pic5;

    @Builder
    public RecipeRecord(User user, String recipe_name, Integer type, Integer cooking_time,
                        String desc1, String desc2, String desc3, String desc4, String desc5,
                        String pic1, String pic2, String pic3, String pic4, String pic5){
        this.user = user;
        this.recipe_name = recipe_name;
        this.type = type;
        this.cooking_time = cooking_time;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;
        this.desc4 = desc4;
        this.desc5 = desc5;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.pic4 = pic4;
        this.pic5 = pic5;
    }
}
