package com.breathe.breatheApi.controllers;

import com.breathe.breatheApi.core.Favorite;
import com.breathe.breatheApi.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/{userId}")
    public List<Favorite> getFavoritesByUserId(@PathVariable(value = "userId") Long userId) {
        return favoriteService.getFavoritesByUserId(userId);
    }

    @PostMapping
    public Favorite createFavorite(Long userId, Long workshopId) {
        return favoriteService.createFavorite(userId, workshopId);
    }

    @DeleteMapping("/{id}")
    public void deleteFavoriteById(@PathVariable(value = "id") Long id) {
        favoriteService.deleteFavorite(id);
    }
}
