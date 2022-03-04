package com.better.forme.domain.diet_record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DietRecordRepository extends JpaRepository<DietRecord, Long> {
}
