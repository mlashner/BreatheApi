package com.breathe.breatheApi.repositories;

import com.breathe.breatheApi.BreatheApiApplicationTests;
import com.breathe.breatheApi.core.User;
import com.breathe.breatheApi.core.Workshop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.*;

public class WorkshopRepositoryTest extends BreatheApiApplicationTests {
    @Autowired
    private WorkshopRepository workshopRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        Workshop workshop = Workshop.builder()
                .title("Come Play With Me")
                .description("everybody happi")
                .startTime(LocalDateTime.of(2019, 7, 11, 11, 30))
                .endTime(LocalDateTime.of(2019, 7, 11, 13, 0))
                .build();
        Long id = workshopRepository.save(workshop).getId();

        Optional<Workshop> savedWorkshop = workshopRepository.findById(id);
        assertTrue(savedWorkshop.isPresent());
        assertEquals(savedWorkshop.get().getEndTime(), LocalDateTime.of(2019, 7, 11, 11, 30).plusMinutes(90));
    }

    @Test
    @Transactional
    public void testUpdate() {
        Workshop workshop = Workshop.builder()
                .title("Come Play With Me")
                .description("everybody happi")
                .startTime(LocalDateTime.of(2019, 7, 11, 11, 30))
                .endTime(LocalDateTime.of(2019, 7, 11, 13, 0))
                .build();
        Long id = workshopRepository.save(workshop).getId();

        Optional<Workshop> savedWorkshop = workshopRepository.findById(id);
        assertTrue(savedWorkshop.isPresent());

        User user = User.builder()
                .fullName("The Dude")
                .email("thedudeabides@bowling.us")
                .build();
        user = userRepository.save(user);

        savedWorkshop.get().setPrimaryInstructor(user);
        workshopRepository.save(savedWorkshop.get());

        Optional<Workshop> updatedWorkshop = workshopRepository.findById(id);
        assertTrue(updatedWorkshop.isPresent());
        assertEquals(updatedWorkshop.get().getPrimaryInstructor(), user);
    }

    @Test
    public void testDelete() {
        Workshop workshop = Workshop.builder()
                .title("Come Play With Me")
                .description("everybody happi")
                .startTime(LocalDateTime.of(2019, 7, 11, 11, 30))
                .endTime(LocalDateTime.of(2019, 7, 11, 13, 0))
                .build();
        Long id = workshopRepository.save(workshop).getId();

        Optional<Workshop> savedWorkshop = workshopRepository.findById(id);
        assertTrue(savedWorkshop.isPresent());

        workshopRepository.delete(savedWorkshop.get());
        Optional<Workshop> deletedWorkshop = workshopRepository.findById(id);
        assertFalse(deletedWorkshop.isPresent());
    }
}