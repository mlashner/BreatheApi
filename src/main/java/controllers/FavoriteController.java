package controllers;

import com.breathe.breatheApi.core.Favorite;
import com.breathe.breatheApi.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/{userId}")
    public List<Favorite> getFavoritesByUserId(@PathVariable(value = "userId") Long userId) {
        return favoriteService.getFavoritesByUserId(userId);
    }

    @PostMapping
    public Favorite createFavorite(@Valid @RequestBody Favorite favorite) {
        return favoriteService.createFavorite(favorite);
    }

    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable(value = "id") Long id) {
        favoriteService.deleteFavorite(id);
    }
}
