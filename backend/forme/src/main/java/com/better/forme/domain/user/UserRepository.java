package com.better.forme.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT p.id, p.age FROM User p ORDER BY p.id DESC ")
    List<User> findAllDesc_User();
}
