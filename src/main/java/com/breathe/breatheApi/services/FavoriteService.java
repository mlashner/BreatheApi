package com.breathe.breatheApi.services;

import com.breathe.breatheApi.core.Favorite;
import com.breathe.breatheApi.core.User;
import com.breathe.breatheApi.core.Workshop;
import com.breathe.breatheApi.repositories.FavoriteRepository;
import com.breathe.breatheApi.repositories.UserRepository;
import com.breathe.breatheApi.repositories.WorkshopRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkshopRepository workshopRepository;

    public Favorite findById(Long id) {
        return favoriteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Favorite.class, "Favorite not found for id :: " + id));
    }

    public List<Workshop> getFavoritesByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, "User not found for id :: " + userId));
        return user.getFavorites().stream()
                .map(Favorite::getWorkshop)
                .sorted(Comparator.comparing(Workshop::getStartTime))
                .collect(Collectors.toList());
    }

    public Favorite createFavorite(Long userId, Long workshopId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, "User not found for id :: " + userId));
        Workshop workshop = workshopRepository.findById(workshopId)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, "Workshop not found for id :: " + workshopId));

        Favorite favorite = Favorite.builder()
                .user(user)
                .workshop(workshop)
                .build();

        return favoriteRepository.save(favorite);
    }

    public void deleteFavorite(Long userId, Long workshopId) {
        favoriteRepository.delete(favoriteRepository.findByUserIdAndWorkshopId(userId, workshopId)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, "Favorite not found")));
    }
}
