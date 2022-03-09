package com.better.forme.domain.recipe_record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRecordRepository extends JpaRepository<RecipeRecord, Long> {

    @Query("SELECT d FROM RecipeRecord d WHERE d.user.id=:userid")
    List<RecipeRecord> findRecipeRecordUser(@Param("userid") Long user);

    @Query("SELECT d FROM RecipeRecord d WHERE d.user.id=:userid AND d.id=:id")
    List<RecipeRecord> findOneRecipeRecordUser(@Param("userid") Long user, @Param("id") Long id);

}
