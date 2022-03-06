package com.better.forme.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT p FROM User p ORDER BY p.id DESC ")
    List<User> findAllDesc_User();
}
