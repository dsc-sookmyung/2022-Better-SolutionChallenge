package com.better.forme.domain.likes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    @Query("SELECT COUNT(*) FROM Likes l WHERE l.id=:recipe_id and l.likes=1")
    Long countRecipeLikes(@Param("recipe_id") Long recipe_id);
}
