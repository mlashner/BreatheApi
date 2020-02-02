package com.breathe.breatheApi.repositories;

import com.breathe.breatheApi.core.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("SELECT t FROM Teacher t WHERE t.fullName = :fullName")
    Optional<Teacher> findByFullName(@Param("fullName") String fullName);
}
