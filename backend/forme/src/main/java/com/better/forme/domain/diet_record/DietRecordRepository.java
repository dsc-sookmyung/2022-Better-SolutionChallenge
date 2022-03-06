package com.better.forme.domain.diet_record;

import com.better.forme.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DietRecordRepository extends JpaRepository<DietRecord, Long> {

    @Query("SELECT d FROM DietRecord d WHERE d.user.id=:userid")
    List<DietRecord> findDietRecordUser(@Param("userid") Long user);

    @Query("SELECT d FROM DietRecord d WHERE d.user.id=:userid AND d.id=:id")
    List<DietRecord> findOneDietRecordUser(@Param("userid") Long user, @Param("id") Long id);
}
