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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

     @ManyToOne
     @JoinColumn(name = "recipe_record_index", nullable = false)
     private RecipeRecord recipe_record_index;

    // temp var for LikeRepository Query
    // private Long recipe_index;

    @Column(nullable = false)
    private Boolean likes;


}
