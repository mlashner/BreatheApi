package com.breathe.breatheApi.repositories;

import com.breathe.breatheApi.core.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    @Query("FROM Favorite WHERE user_id = :userId AND workshop_id = :workshopId")
    Optional<Favorite> findByUserIdAndWorkshopId(@Param("userId") Long userId, @Param("workshopId") Long workshopId);
}