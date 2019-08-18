package com.breathe.breatheApi.services;

import com.breathe.breatheApi.core.Favorite;
import com.breathe.breatheApi.core.User;
import com.breathe.breatheApi.repositories.FavoriteRepository;
import com.breathe.breatheApi.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    public Favorite findById(Long id) {
        return favoriteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Favorite.class, "Favorite not found for id :: " + id));
    }

    public List<Favorite> getFavoritesByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, "User not found for id :: " + userId));
        return user.getFavorites();
    }

    public Favorite createFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public void deleteFavorite(Long id) {
        favoriteRepository.delete(findById(id));
    }
}
