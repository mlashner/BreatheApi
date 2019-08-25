package com.breathe.breatheApi.repositories;

import com.breathe.breatheApi.core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.installationId = :installationId")
    Optional<User> findByInstallationId(@Param("installationId") String installationId);
}
