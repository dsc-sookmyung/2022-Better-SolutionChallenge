package com.better.forme.domain.likes;

import com.better.forme.domain.recipe_record.RecipeRecord;
import com.better.forme.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likes_index;

    @OneToOne
    @JoinColumn(name = "user_key", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "recipe_index", nullable = false)
    private RecipeRecord recipe_index;

    @Column(nullable = false)
    private Boolean likes;


}
