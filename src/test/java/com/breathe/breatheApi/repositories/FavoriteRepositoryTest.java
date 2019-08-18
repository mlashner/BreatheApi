package com.breathe.breatheApi.repositories;

import com.breathe.breatheApi.BreatheApiApplicationTests;
import com.breathe.breatheApi.core.Favorite;
import com.breathe.breatheApi.core.User;
import com.breathe.breatheApi.core.Workshop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.Assert.*;

public class FavoriteRepositoryTest extends BreatheApiApplicationTests {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkshopRepository workshopRepository;

    @Test
    @Transactional
    public void testCreate() {
        Workshop workshop = Workshop.builder()
                .title("Come Play With Me")
                .description("everybody happi")
                .build();
        Long workshopId = workshopRepository.save(workshop).getId();

        Optional<Workshop> savedWorkshop = workshopRepository.findById(workshopId);
        assertTrue(savedWorkshop.isPresent());

        User user = User.builder()
                .fullName("The Dude")
                .email("thedudeabides@bowling.us")
                .build();
        user = userRepository.save(user);

        Favorite favorite = Favorite.builder()
                .user(user)
                .workshop(savedWorkshop.get())
                .build();
        Long id = favoriteRepository.save(favorite).getId();

        Optional<Favorite> savedFavorite = favoriteRepository.findById(id);
        assertTrue(savedFavorite.isPresent());
        assertEquals(savedFavorite.get().getUser(), user);
        assertEquals(savedFavorite.get().getWorkshop(), savedWorkshop.get());
    }

    @Test
    public void testDelete() {
        Workshop workshop = Workshop.builder()
                .title("Come Play With Me")
                .description("everybody happi")
                .build();
        Long workshopId = workshopRepository.save(workshop).getId();

        Optional<Workshop> savedWorkshop = workshopRepository.findById(workshopId);
        assertTrue(savedWorkshop.isPresent());

        User user = User.builder()
                .fullName("The Dude")
                .email("thedudeabides@bowling.us")
                .build();
        user = userRepository.save(user);

        Favorite favorite = Favorite.builder()
                .user(user)
                .workshop(savedWorkshop.get())
                .build();
        Long id = favoriteRepository.save(favorite).getId();

        Optional<Favorite> savedFavorite = favoriteRepository.findById(id);
        assertTrue(savedFavorite.isPresent());

        favoriteRepository.delete(savedFavorite.get());
        Optional<Favorite> deletedFavorite = favoriteRepository.findById(id);
        assertFalse(deletedFavorite.isPresent());
    }
}