package com.better.forme.domain.character;

import com.better.forme.domain.diet_record.DietRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TomatoCharacterRepository extends JpaRepository<TomatoCharacter, Long> {
}
