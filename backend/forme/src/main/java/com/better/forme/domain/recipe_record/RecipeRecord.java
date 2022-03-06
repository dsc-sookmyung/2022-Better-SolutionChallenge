package com.better.forme.domain.recipe_record;

import com.better.forme.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class RecipeRecord {

    @Id
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe_index;

    @OneToOne
    @JoinColumn(name = "user_key")
    private User user;

    @Column(nullable = false)
    private String recipe_name;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false)
    private Integer cooking_time;

    @Column(nullable = false)
    private String desc1;

    @Column(nullable = false)
    private String desc2;

    @Column(nullable = false)
    private String desc3;

    @Column(nullable = false)
    private String desc4;

    @Column(nullable = false)
    private String desc5;
}
